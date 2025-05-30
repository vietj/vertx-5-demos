package com.julienviet.demos;

import com.julienviet.demos.db.TestContainerHelper;
import com.julienviet.demos.movierating.*;
import io.vertx.core.*;
import io.vertx.core.http.HttpServer;
import io.vertx.grpc.common.GrpcStatus;
import io.vertx.grpc.reflection.ReflectionService;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpc.server.StatusException;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.sqlclient.*;

import java.util.function.Function;

public class MovieRatings extends VerticleBase {

  public static void main(String[] args) {
    TestContainerHelper helper = new TestContainerHelper();
    PgConnectOptions options = helper.startDb();
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MovieRatings(options), new DeploymentOptions().setThreadingModel(ThreadingModel.VIRTUAL_THREAD)).await();
  }

  private final PgConnectOptions options;

  public MovieRatings(PgConnectOptions options) {
    this.options = options;
  }

  @Override
  public Future<?> start() throws Exception {

    Pool pool = Pool.pool(vertx, options, new PoolOptions());

    HttpServer httpServer = vertx.createHttpServer();

    GrpcServer grpcServer = GrpcServer.server(vertx);

    grpcServer.addService(ReflectionService.v1());


    grpcServer.addService(new MovieRatingDatabaseGrpcService() {
      @Override
      public Future<MovieDetails> getMovieDetails(MovieId request) {
        return pool
          .preparedQuery("SELECT title FROM movie_details WHERE id=$1")
          .execute(Tuple.of(request.getId()))
          .map(toSingleRow)
          .map(row -> MovieDetails
            .newBuilder()
            .setId(request.getId())
            .setTitle(row.getString(0))
            .build()
          );
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
            .map(toSingleRow)
            .compose(row -> {
              String id = row.getString(0);
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
          .map(toSingleRow)
          .map(row -> MovieRatingDetails
            .newBuilder()
            .setId(request.getId())
            .setRating(row.getInteger(0))
            .build());
      }
    });

    return httpServer
      .requestHandler(grpcServer)
      .listen(8080, "localhost");
  }

  // Helper
  private static final Function<RowSet<Row>, Row> toSingleRow = rows -> {
    if (rows.size() == 1) {
      return rows.iterator().next();
    } else {
      throw new StatusException(GrpcStatus.NOT_FOUND);
    }
  };
}
