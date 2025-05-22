package examples.movie_rating;

import static examples.movie_rating.MovieRatingDatabaseGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

import io.grpc.ClientCall;

import io.grpc.stub.StreamObserver;

import io.vertx.grpcio.client.GrpcIoClientChannel;
import io.vertx.grpcio.client.impl.GrpcIoClientImpl;

/**
 * gRPC/IO client/service in a Vert.x idiomatic way.
 */
public final class MovieRatingDatabaseGrpcIo {

  private MovieRatingDatabaseGrpcIo() {}

  /**
   * Build a new stub.
   */
  public static MovieRatingDatabaseStub newStub(io.vertx.grpcio.client.GrpcIoClient client, io.vertx.core.net.SocketAddress socketAddress) {
    return newStub(((GrpcIoClientImpl)client).vertx(), new io.vertx.grpcio.client.GrpcIoClientChannel(client, socketAddress));
  }

  /**
   * Build a new stub.
   */
  public static MovieRatingDatabaseStub newStub(io.vertx.core.Vertx vertx, io.grpc.Channel channel) {
    return new MovieRatingDatabaseStub(vertx, channel);
  }

  
  public static final class MovieRatingDatabaseStub extends io.grpc.stub.AbstractStub<MovieRatingDatabaseStub> implements MovieRatingDatabaseClient {
    private final io.vertx.core.internal.ContextInternal context;
    private MovieRatingDatabaseGrpc.MovieRatingDatabaseStub delegateStub;

    private MovieRatingDatabaseStub(io.vertx.core.Vertx vertx, io.grpc.Channel channel) {
      super(channel);
      this.delegateStub = MovieRatingDatabaseGrpc.newStub(channel);
      this.context = (io.vertx.core.internal.ContextInternal)vertx.getOrCreateContext();
    }

    private MovieRatingDatabaseStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
      this.delegateStub = MovieRatingDatabaseGrpc.newStub(channel).build(channel, callOptions);
      this.context = (io.vertx.core.internal.ContextInternal) ((GrpcIoClientImpl)((GrpcIoClientChannel)getChannel()).client()).vertx().getOrCreateContext();
    }

    @Override
    protected MovieRatingDatabaseStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieRatingDatabaseStub(channel, callOptions);
    }

    
    public io.vertx.core.Future<examples.movie_rating.MovieDetails> getMovieDetails(examples.movie_rating.MovieId request) {
      return io.vertx.grpcio.common.impl.stub.ClientCalls.oneToOne(context, request, delegateStub::getMovieDetails);
    }

    
    public io.vertx.core.Future<examples.movie_rating.Empty> rateMovie(examples.movie_rating.MovieRating request) {
      return io.vertx.grpcio.common.impl.stub.ClientCalls.oneToOne(context, request, delegateStub::rateMovie);
    }

    
    public io.vertx.core.Future<examples.movie_rating.MovieRatingDetails> getMovieRating(examples.movie_rating.MovieId request) {
      return io.vertx.grpcio.common.impl.stub.ClientCalls.oneToOne(context, request, delegateStub::getMovieRating);
    }

  }

  /**
   * @return a service binding the given {@code service}.
   */
  public static io.grpc.BindableService bindableServiceOf(MovieRatingDatabaseService service) {
    return new io.grpc.BindableService() {
      public io.grpc.ServerServiceDefinition bindService() {
        return serverServiceDefinition(service);
      }
    };
  }

  private static io.grpc.ServerServiceDefinition serverServiceDefinition(MovieRatingDatabaseService service) {
    String compression = null;
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
      .addMethod(
        examples.movie_rating.MovieRatingDatabaseGrpc.getGetMovieDetailsMethod(),
        asyncUnaryCall(
                new MethodHandlers<
                        examples.movie_rating.MovieId,
                        examples.movie_rating.MovieDetails>(
                        service, METHODID_GET_MOVIE_DETAILS, compression)))
      .addMethod(
        examples.movie_rating.MovieRatingDatabaseGrpc.getRateMovieMethod(),
        asyncUnaryCall(
                new MethodHandlers<
                        examples.movie_rating.MovieRating,
                        examples.movie_rating.Empty>(
                        service, METHODID_RATE_MOVIE, compression)))
      .addMethod(
        examples.movie_rating.MovieRatingDatabaseGrpc.getGetMovieRatingMethod(),
        asyncUnaryCall(
                new MethodHandlers<
                        examples.movie_rating.MovieId,
                        examples.movie_rating.MovieRatingDetails>(
                        service, METHODID_GET_MOVIE_RATING, compression)))
      .build();
 }

  private static final int METHODID_GET_MOVIE_DETAILS = 0;
  private static final int METHODID_RATE_MOVIE = 1;
  private static final int METHODID_GET_MOVIE_RATING = 2;

  private static final class MethodHandlers<Req, Resp> implements
          io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

    private final MovieRatingDatabaseService serviceImpl;
    private final int methodId;
    private final String compression;

    MethodHandlers(MovieRatingDatabaseService serviceImpl, int methodId, String compression) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
      this.compression = compression;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MOVIE_DETAILS:
          io.vertx.grpcio.server.impl.stub.ServerCalls.<examples.movie_rating.MovieId, examples.movie_rating.MovieDetails>oneToOne(
            (io.vertx.core.internal.ContextInternal) io.vertx.core.Vertx.currentContext(),
            (examples.movie_rating.MovieId) request,
            (io.grpc.stub.StreamObserver<examples.movie_rating.MovieDetails>) responseObserver,
            compression,
            serviceImpl::getMovieDetails);
          break;
        case METHODID_RATE_MOVIE:
          io.vertx.grpcio.server.impl.stub.ServerCalls.<examples.movie_rating.MovieRating, examples.movie_rating.Empty>oneToOne(
            (io.vertx.core.internal.ContextInternal) io.vertx.core.Vertx.currentContext(),
            (examples.movie_rating.MovieRating) request,
            (io.grpc.stub.StreamObserver<examples.movie_rating.Empty>) responseObserver,
            compression,
            serviceImpl::rateMovie);
          break;
        case METHODID_GET_MOVIE_RATING:
          io.vertx.grpcio.server.impl.stub.ServerCalls.<examples.movie_rating.MovieId, examples.movie_rating.MovieRatingDetails>oneToOne(
            (io.vertx.core.internal.ContextInternal) io.vertx.core.Vertx.currentContext(),
            (examples.movie_rating.MovieId) request,
            (io.grpc.stub.StreamObserver<examples.movie_rating.MovieRatingDetails>) responseObserver,
            compression,
            serviceImpl::getMovieRating);
          break;
        default:
          throw new java.lang.AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
      StreamObserver<Req> reqStreamObserver;
      switch (methodId) {
        default:
          throw new java.lang.AssertionError();
      }
    }
  }
}
