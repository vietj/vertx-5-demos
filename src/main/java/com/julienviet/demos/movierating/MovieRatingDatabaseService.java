package com.julienviet.demos.movierating;

import io.vertx.core.Future;
import io.vertx.core.Completable;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.streams.WriteStream;
import io.vertx.grpc.common.GrpcStatus;
import io.vertx.grpc.common.ServiceName;
import io.vertx.grpc.common.ServiceMethod;
import io.vertx.grpc.common.GrpcMessageDecoder;
import io.vertx.grpc.common.GrpcMessageEncoder;
import io.vertx.grpc.server.GrpcServerRequest;
import io.vertx.grpc.server.GrpcServer;
import io.vertx.grpc.server.Service;
import io.vertx.grpc.server.ServiceBuilder;

import com.google.protobuf.Descriptors;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Provides support for RPC methods implementations of the MovieRatingDatabase gRPC service.</p>
 *
 * <p>The following methods of this class should be overridden to provide an implementation of the service:</p>
 * <ul>
 *   <li>GetMovieDetails</li>
 *   <li>RateMovie</li>
 *   <li>GetMovieRating</li>
 * </ul>
 */
public class MovieRatingDatabaseService implements MovieRatingDatabase {

  /**
   * Override this method to implement the GetMovieDetails RPC.
   */
  public Future<com.julienviet.demos.movierating.MovieDetails> getMovieDetails(com.julienviet.demos.movierating.MovieId request) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected void getMovieDetails(com.julienviet.demos.movierating.MovieId request, Completable<com.julienviet.demos.movierating.MovieDetails> response) {
    getMovieDetails(request).onComplete(response);
  }

  /**
   * Override this method to implement the RateMovie RPC.
   */
  public Future<com.julienviet.demos.movierating.Empty> rateMovie(com.julienviet.demos.movierating.MovieRating request) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected void rateMovie(com.julienviet.demos.movierating.MovieRating request, Completable<com.julienviet.demos.movierating.Empty> response) {
    rateMovie(request).onComplete(response);
  }

  /**
   * Override this method to implement the GetMovieRating RPC.
   */
  public Future<com.julienviet.demos.movierating.MovieRatingDetails> getMovieRating(com.julienviet.demos.movierating.MovieId request) {
    throw new UnsupportedOperationException("Not implemented");
  }

  protected void getMovieRating(com.julienviet.demos.movierating.MovieId request, Completable<com.julienviet.demos.movierating.MovieRatingDetails> response) {
    getMovieRating(request).onComplete(response);
  }
}
