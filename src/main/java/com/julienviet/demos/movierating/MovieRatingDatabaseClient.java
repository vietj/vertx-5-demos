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
public interface MovieRatingDatabaseClient extends MovieRatingDatabase {

  /**
   * Calls the GetMovieDetails RPC service method.
   *
   * @param request the com.julienviet.demos.movierating.MovieId request message
   * @return a future of the com.julienviet.demos.movierating.MovieDetails response message
   */
  Future<com.julienviet.demos.movierating.MovieDetails> getMovieDetails(com.julienviet.demos.movierating.MovieId request);

  /**
   * Calls the RateMovie RPC service method.
   *
   * @param request the com.julienviet.demos.movierating.MovieRating request message
   * @return a future of the com.julienviet.demos.movierating.Empty response message
   */
  Future<com.julienviet.demos.movierating.Empty> rateMovie(com.julienviet.demos.movierating.MovieRating request);

  /**
   * Calls the GetMovieRating RPC service method.
   *
   * @param request the com.julienviet.demos.movierating.MovieId request message
   * @return a future of the com.julienviet.demos.movierating.MovieRatingDetails response message
   */
  Future<com.julienviet.demos.movierating.MovieRatingDetails> getMovieRating(com.julienviet.demos.movierating.MovieId request);
}
