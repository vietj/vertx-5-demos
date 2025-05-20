package examples.movie_rating;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class MovieRatingDatabaseGrpc {

  private MovieRatingDatabaseGrpc() {}

  public static final java.lang.String SERVICE_NAME = "examples.grpc.MovieRatingDatabase";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<examples.movie_rating.MovieId,
      examples.movie_rating.MovieDetails> getGetMovieDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMovieDetails",
      requestType = examples.movie_rating.MovieId.class,
      responseType = examples.movie_rating.MovieDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<examples.movie_rating.MovieId,
      examples.movie_rating.MovieDetails> getGetMovieDetailsMethod() {
    io.grpc.MethodDescriptor<examples.movie_rating.MovieId, examples.movie_rating.MovieDetails> getGetMovieDetailsMethod;
    if ((getGetMovieDetailsMethod = MovieRatingDatabaseGrpc.getGetMovieDetailsMethod) == null) {
      synchronized (MovieRatingDatabaseGrpc.class) {
        if ((getGetMovieDetailsMethod = MovieRatingDatabaseGrpc.getGetMovieDetailsMethod) == null) {
          MovieRatingDatabaseGrpc.getGetMovieDetailsMethod = getGetMovieDetailsMethod =
              io.grpc.MethodDescriptor.<examples.movie_rating.MovieId, examples.movie_rating.MovieDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMovieDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  examples.movie_rating.MovieId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  examples.movie_rating.MovieDetails.getDefaultInstance()))
              .setSchemaDescriptor(new MovieRatingDatabaseMethodDescriptorSupplier("GetMovieDetails"))
              .build();
        }
      }
    }
    return getGetMovieDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<examples.movie_rating.MovieRating,
      examples.movie_rating.Empty> getRateMovieMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RateMovie",
      requestType = examples.movie_rating.MovieRating.class,
      responseType = examples.movie_rating.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<examples.movie_rating.MovieRating,
      examples.movie_rating.Empty> getRateMovieMethod() {
    io.grpc.MethodDescriptor<examples.movie_rating.MovieRating, examples.movie_rating.Empty> getRateMovieMethod;
    if ((getRateMovieMethod = MovieRatingDatabaseGrpc.getRateMovieMethod) == null) {
      synchronized (MovieRatingDatabaseGrpc.class) {
        if ((getRateMovieMethod = MovieRatingDatabaseGrpc.getRateMovieMethod) == null) {
          MovieRatingDatabaseGrpc.getRateMovieMethod = getRateMovieMethod =
              io.grpc.MethodDescriptor.<examples.movie_rating.MovieRating, examples.movie_rating.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RateMovie"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  examples.movie_rating.MovieRating.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  examples.movie_rating.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MovieRatingDatabaseMethodDescriptorSupplier("RateMovie"))
              .build();
        }
      }
    }
    return getRateMovieMethod;
  }

  private static volatile io.grpc.MethodDescriptor<examples.movie_rating.MovieId,
      examples.movie_rating.MovieRatingDetails> getGetMovieRatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMovieRating",
      requestType = examples.movie_rating.MovieId.class,
      responseType = examples.movie_rating.MovieRatingDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<examples.movie_rating.MovieId,
      examples.movie_rating.MovieRatingDetails> getGetMovieRatingMethod() {
    io.grpc.MethodDescriptor<examples.movie_rating.MovieId, examples.movie_rating.MovieRatingDetails> getGetMovieRatingMethod;
    if ((getGetMovieRatingMethod = MovieRatingDatabaseGrpc.getGetMovieRatingMethod) == null) {
      synchronized (MovieRatingDatabaseGrpc.class) {
        if ((getGetMovieRatingMethod = MovieRatingDatabaseGrpc.getGetMovieRatingMethod) == null) {
          MovieRatingDatabaseGrpc.getGetMovieRatingMethod = getGetMovieRatingMethod =
              io.grpc.MethodDescriptor.<examples.movie_rating.MovieId, examples.movie_rating.MovieRatingDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMovieRating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  examples.movie_rating.MovieId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  examples.movie_rating.MovieRatingDetails.getDefaultInstance()))
              .setSchemaDescriptor(new MovieRatingDatabaseMethodDescriptorSupplier("GetMovieRating"))
              .build();
        }
      }
    }
    return getGetMovieRatingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MovieRatingDatabaseStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieRatingDatabaseStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieRatingDatabaseStub>() {
        @java.lang.Override
        public MovieRatingDatabaseStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieRatingDatabaseStub(channel, callOptions);
        }
      };
    return MovieRatingDatabaseStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static MovieRatingDatabaseBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieRatingDatabaseBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieRatingDatabaseBlockingV2Stub>() {
        @java.lang.Override
        public MovieRatingDatabaseBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieRatingDatabaseBlockingV2Stub(channel, callOptions);
        }
      };
    return MovieRatingDatabaseBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MovieRatingDatabaseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieRatingDatabaseBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieRatingDatabaseBlockingStub>() {
        @java.lang.Override
        public MovieRatingDatabaseBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieRatingDatabaseBlockingStub(channel, callOptions);
        }
      };
    return MovieRatingDatabaseBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MovieRatingDatabaseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MovieRatingDatabaseFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MovieRatingDatabaseFutureStub>() {
        @java.lang.Override
        public MovieRatingDatabaseFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MovieRatingDatabaseFutureStub(channel, callOptions);
        }
      };
    return MovieRatingDatabaseFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getMovieDetails(examples.movie_rating.MovieId request,
        io.grpc.stub.StreamObserver<examples.movie_rating.MovieDetails> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMovieDetailsMethod(), responseObserver);
    }

    /**
     */
    default void rateMovie(examples.movie_rating.MovieRating request,
        io.grpc.stub.StreamObserver<examples.movie_rating.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRateMovieMethod(), responseObserver);
    }

    /**
     */
    default void getMovieRating(examples.movie_rating.MovieId request,
        io.grpc.stub.StreamObserver<examples.movie_rating.MovieRatingDetails> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMovieRatingMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MovieRatingDatabase.
   */
  public static abstract class MovieRatingDatabaseImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MovieRatingDatabaseGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MovieRatingDatabase.
   */
  public static final class MovieRatingDatabaseStub
      extends io.grpc.stub.AbstractAsyncStub<MovieRatingDatabaseStub> {
    private MovieRatingDatabaseStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieRatingDatabaseStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieRatingDatabaseStub(channel, callOptions);
    }

    /**
     */
    public void getMovieDetails(examples.movie_rating.MovieId request,
        io.grpc.stub.StreamObserver<examples.movie_rating.MovieDetails> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMovieDetailsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rateMovie(examples.movie_rating.MovieRating request,
        io.grpc.stub.StreamObserver<examples.movie_rating.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRateMovieMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMovieRating(examples.movie_rating.MovieId request,
        io.grpc.stub.StreamObserver<examples.movie_rating.MovieRatingDetails> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMovieRatingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MovieRatingDatabase.
   */
  public static final class MovieRatingDatabaseBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MovieRatingDatabaseBlockingV2Stub> {
    private MovieRatingDatabaseBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieRatingDatabaseBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieRatingDatabaseBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public examples.movie_rating.MovieDetails getMovieDetails(examples.movie_rating.MovieId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMovieDetailsMethod(), getCallOptions(), request);
    }

    /**
     */
    public examples.movie_rating.Empty rateMovie(examples.movie_rating.MovieRating request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRateMovieMethod(), getCallOptions(), request);
    }

    /**
     */
    public examples.movie_rating.MovieRatingDetails getMovieRating(examples.movie_rating.MovieId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMovieRatingMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service MovieRatingDatabase.
   */
  public static final class MovieRatingDatabaseBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MovieRatingDatabaseBlockingStub> {
    private MovieRatingDatabaseBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieRatingDatabaseBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieRatingDatabaseBlockingStub(channel, callOptions);
    }

    /**
     */
    public examples.movie_rating.MovieDetails getMovieDetails(examples.movie_rating.MovieId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMovieDetailsMethod(), getCallOptions(), request);
    }

    /**
     */
    public examples.movie_rating.Empty rateMovie(examples.movie_rating.MovieRating request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRateMovieMethod(), getCallOptions(), request);
    }

    /**
     */
    public examples.movie_rating.MovieRatingDetails getMovieRating(examples.movie_rating.MovieId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMovieRatingMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MovieRatingDatabase.
   */
  public static final class MovieRatingDatabaseFutureStub
      extends io.grpc.stub.AbstractFutureStub<MovieRatingDatabaseFutureStub> {
    private MovieRatingDatabaseFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieRatingDatabaseFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MovieRatingDatabaseFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<examples.movie_rating.MovieDetails> getMovieDetails(
        examples.movie_rating.MovieId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMovieDetailsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<examples.movie_rating.Empty> rateMovie(
        examples.movie_rating.MovieRating request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRateMovieMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<examples.movie_rating.MovieRatingDetails> getMovieRating(
        examples.movie_rating.MovieId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMovieRatingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MOVIE_DETAILS = 0;
  private static final int METHODID_RATE_MOVIE = 1;
  private static final int METHODID_GET_MOVIE_RATING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MOVIE_DETAILS:
          serviceImpl.getMovieDetails((examples.movie_rating.MovieId) request,
              (io.grpc.stub.StreamObserver<examples.movie_rating.MovieDetails>) responseObserver);
          break;
        case METHODID_RATE_MOVIE:
          serviceImpl.rateMovie((examples.movie_rating.MovieRating) request,
              (io.grpc.stub.StreamObserver<examples.movie_rating.Empty>) responseObserver);
          break;
        case METHODID_GET_MOVIE_RATING:
          serviceImpl.getMovieRating((examples.movie_rating.MovieId) request,
              (io.grpc.stub.StreamObserver<examples.movie_rating.MovieRatingDetails>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetMovieDetailsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              examples.movie_rating.MovieId,
              examples.movie_rating.MovieDetails>(
                service, METHODID_GET_MOVIE_DETAILS)))
        .addMethod(
          getRateMovieMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              examples.movie_rating.MovieRating,
              examples.movie_rating.Empty>(
                service, METHODID_RATE_MOVIE)))
        .addMethod(
          getGetMovieRatingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              examples.movie_rating.MovieId,
              examples.movie_rating.MovieRatingDetails>(
                service, METHODID_GET_MOVIE_RATING)))
        .build();
  }

  private static abstract class MovieRatingDatabaseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MovieRatingDatabaseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return examples.movie_rating.MovieRatingOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MovieRatingDatabase");
    }
  }

  private static final class MovieRatingDatabaseFileDescriptorSupplier
      extends MovieRatingDatabaseBaseDescriptorSupplier {
    MovieRatingDatabaseFileDescriptorSupplier() {}
  }

  private static final class MovieRatingDatabaseMethodDescriptorSupplier
      extends MovieRatingDatabaseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MovieRatingDatabaseMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MovieRatingDatabaseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MovieRatingDatabaseFileDescriptorSupplier())
              .addMethod(getGetMovieDetailsMethod())
              .addMethod(getRateMovieMethod())
              .addMethod(getGetMovieRatingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
