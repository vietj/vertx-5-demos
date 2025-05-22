package com.julienviet.demos.movierating;

import io.vertx.core.Future;
import io.vertx.core.Completable;
import io.vertx.core.Handler;
import io.vertx.core.net.SocketAddress;
import io.vertx.grpc.client.GrpcClient;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;
import io.vertx.grpc.common.GrpcStatus;
import io.vertx.grpc.common.ServiceName;
import io.vertx.grpc.common.ServiceMethod;
import io.vertx.grpc.common.GrpcMessageDecoder;
import io.vertx.grpc.common.GrpcMessageEncoder;

/**
 * <p>A client for invoking the MovieRatingDatabase gRPC service.</p>
 */
public interface MovieRatingDatabaseGrpcClient extends MovieRatingDatabaseClient {

  /**
   * GetMovieDetails protobuf RPC client service method.
   */
  ServiceMethod<com.julienviet.demos.movierating.MovieDetails, com.julienviet.demos.movierating.MovieId> GetMovieDetails = ServiceMethod.client(
    ServiceName.create("examples.grpc", "MovieRatingDatabase"),
    "GetMovieDetails",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.julienviet.demos.movierating.MovieDetails.newBuilder()));

  /**
   * RateMovie protobuf RPC client service method.
   */
  ServiceMethod<com.julienviet.demos.movierating.Empty, com.julienviet.demos.movierating.MovieRating> RateMovie = ServiceMethod.client(
    ServiceName.create("examples.grpc", "MovieRatingDatabase"),
    "RateMovie",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.julienviet.demos.movierating.Empty.newBuilder()));

  /**
   * GetMovieRating protobuf RPC client service method.
   */
  ServiceMethod<com.julienviet.demos.movierating.MovieRatingDetails, com.julienviet.demos.movierating.MovieId> GetMovieRating = ServiceMethod.client(
    ServiceName.create("examples.grpc", "MovieRatingDatabase"),
    "GetMovieRating",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.julienviet.demos.movierating.MovieRatingDetails.newBuilder()));

  /**
   * Create and return a MovieRatingDatabase gRPC service client. The assumed wire format is Protobuf.
   *
   * @param client the gRPC client
   * @param host   the host providing the service
   * @return the configured client
   */
  static MovieRatingDatabaseGrpcClient create(GrpcClient client, SocketAddress host) {
    return new MovieRatingDatabaseGrpcClientImpl(client, host);
  }

  /**
   * Create and return a MovieRatingDatabase gRPC service client.
   *
   * @param client     the gRPC client
   * @param host       the host providing the service
   * @param wireFormat the wire format
   * @return the configured client
   */
  static MovieRatingDatabaseGrpcClient create(GrpcClient client, SocketAddress host, io.vertx.grpc.common.WireFormat wireFormat) {
    return new MovieRatingDatabaseGrpcClientImpl(client, host, wireFormat);
  }
}

/**
 * The proxy implementation.
 */
class MovieRatingDatabaseGrpcClientImpl implements MovieRatingDatabaseGrpcClient {

  private final GrpcClient client;
  private final SocketAddress socketAddress;
  private final io.vertx.grpc.common.WireFormat wireFormat;

  MovieRatingDatabaseGrpcClientImpl(GrpcClient client, SocketAddress socketAddress) {
    this(client, socketAddress, io.vertx.grpc.common.WireFormat.PROTOBUF);
  }

  MovieRatingDatabaseGrpcClientImpl(GrpcClient client, SocketAddress socketAddress, io.vertx.grpc.common.WireFormat wireFormat) {
    this.client = java.util.Objects.requireNonNull(client);
    this.socketAddress = java.util.Objects.requireNonNull(socketAddress);
    this.wireFormat = java.util.Objects.requireNonNull(wireFormat);
  }

  public Future<com.julienviet.demos.movierating.MovieDetails> getMovieDetails(com.julienviet.demos.movierating.MovieId request) {
    return client.request(socketAddress, GetMovieDetails).compose(req -> {
      req.format(wireFormat);
      return req.end(request).compose(v -> req.response().compose(resp -> resp.last()));
    });
  }

  public Future<com.julienviet.demos.movierating.Empty> rateMovie(com.julienviet.demos.movierating.MovieRating request) {
    return client.request(socketAddress, RateMovie).compose(req -> {
      req.format(wireFormat);
      return req.end(request).compose(v -> req.response().compose(resp -> resp.last()));
    });
  }

  public Future<com.julienviet.demos.movierating.MovieRatingDetails> getMovieRating(com.julienviet.demos.movierating.MovieId request) {
    return client.request(socketAddress, GetMovieRating).compose(req -> {
      req.format(wireFormat);
      return req.end(request).compose(v -> req.response().compose(resp -> resp.last()));
    });
  }
}
