package com.julienviet.demos.helloworld1;

import examples.grpc.GreeterGrpc;
import examples.grpc.GreeterGrpcService;
import examples.grpc.HelloReply;
import examples.grpc.HelloRequest;
import examples.movie_rating.*;
import io.grpc.stub.StreamObserver;
import io.vertx.core.Expectation;
import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.grpc.common.GrpcStatus;
import io.vertx.grpc.reflection.ReflectionService;
import io.vertx.grpc.server.StatusException;
import io.vertx.grpcio.server.GrpcIoServer;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.sqlclient.*;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class Main extends VerticleBase {

  public static void main(String[] args) {

/*
    var postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:17"))
      .withInitScript("");
    postgres.start();
*/
    PostgresServerHelper helper = new PostgresServerHelper();

    PgConnectOptions options = helper.startDb();

    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle(new Main(options)).await();


  }

  private final PgConnectOptions options;

  public Main(PgConnectOptions options) {
    this.options = options;
  }

  @Override
  public Future<?> start() throws Exception {
    Pool pool = Pool.pool(vertx, options, new PoolOptions());

    HttpServer httpServer = vertx.createHttpServer();

    GrpcIoServer grpcServer = GrpcIoServer.server(vertx);

    grpcServer.addService(ReflectionService.v1());

/*
    grpcServer.addService(new GreeterGrpc.GreeterImplBase() {
      @Override
      public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        responseObserver.onNext(HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
        responseObserver.onCompleted();
      }
    });
*/

    grpcServer.addService(new GreeterGrpcService() {
      @Override
      public Future<HelloReply> sayHello(HelloRequest request) {

        return vertx
          .timer(200) // Should be a database interaction
          .map(v -> HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
      }
    });

    grpcServer.addService(new MovieRatingDatabaseGrpcService() {
      @Override
      public Future<MovieDetails> getMovieDetails(MovieId request) {
        return pool
          .preparedQuery("SELECT title FROM movie_details WHERE id=$1")
          .execute(Tuple.of(request.getId()))
          .expecting(SINGLE_ROW)
          .map(rows -> MovieDetails.newBuilder().setId(request.getId()).setTitle(rows.iterator().next().getString(0)).build());
      }
      @Override
      public Future<Empty> rateMovie(MovieRating request) {
        if (!request.getId().isEmpty()) {
          return pool
            .preparedQuery("INSERT INTO movie_ratings (id, rating) VALUES ($1, $2)")
            .execute(Tuple.of(request.getId(), request.getRating()))
            .map(Empty.getDefaultInstance());
        } else {
          return pool
            .preparedQuery("SELECT id FROM movie_details WHERE title=$1")
            .execute(Tuple.of(request.getTitle()))
            .expecting(SINGLE_ROW)
            .compose(rows -> {
              String id = rows.iterator().next().getString(0);
              return pool
                .preparedQuery("INSERT INTO movie_ratings (id, rating) VALUES ($1, $2)")
                .execute(Tuple.of(id, request.getRating()))
                .map(Empty.getDefaultInstance());
            });
        }
      }
      @Override
      public Future<MovieRatingDetails> getMovieRating(MovieId request) {
        return pool
          .preparedQuery("SELECT AVG(rating) FROM movie_ratings WHERE id=$1")
          .execute(Tuple.of(request.getId()))
          .map(rows -> MovieRatingDetails.newBuilder().setId(request.getId()).setRating(rows.iterator().next().getInteger(0)).build());
      }
    });

    httpServer.requestHandler(grpcServer);

    return httpServer
      .listen(8080, "localhost");

    // grpcurl -plaintext localhost:8080 list
    // grpcurl -plaintext localhost:8080 list examples.grpc.Greeter
    // grpcurl -plaintext localhost:8080 list examples.grpc.Greeter
    // grpcurl -plaintext localhost:8080 describe examples.grpc.Greeter.SayHello
    // grpcurl -plaintext -d '{"name": "Julien"}' localhost:8080 examples.grpc.Greeter/SayHello


    // curl --header "Content-Type: application/json" --request POST --data '{"name":"Julien"}' http://localhost:8080/examples.grpc.Greeter/SayHello

    // grpcurl -plaintext -d '{"id": "starwars"}' localhost:8080 examples.grpc.MovieRatingDatabase/GetMovieDetails
    // grpcurl -plaintext -d '{"id": "starwars","rating":5}' localhost:8080 examples.grpc.MovieRatingDatabase/RateMovie
    // grpcurl -plaintext -d '{"title": "Star Wars","rating":5}' localhost:8080 examples.grpc.MovieRatingDatabase/RateMovie

    // curl --header "Content-Type: application/json" http://localhost:8080/movie_details/starwars
    // curl --header "Content-Type: application/json" http://localhost:8080/movie_ratings/starwars
    // curl --header "Content-Type: application/json" --request POST --data '{"id":"starwars","rating":5}' http://localhost:8080/movie_ratings
  }

  private static final Expectation<? super RowSet<Row>> SINGLE_ROW = new Expectation<>() {
    @Override
    public boolean test(RowSet<Row> rows) {
      return rows.size() == 1;
    }
    @Override
    public Throwable describe(RowSet<Row> value) {
      return new StatusException(GrpcStatus.NOT_FOUND);
    }
  };
}
