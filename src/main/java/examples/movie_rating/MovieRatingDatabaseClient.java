package examples.movie_rating;

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
   * @param request the examples.movie_rating.MovieId request message
   * @return a future of the examples.movie_rating.MovieDetails response message
   */
  Future<examples.movie_rating.MovieDetails> getMovieDetails(examples.movie_rating.MovieId request);

  /**
   * Calls the RateMovie RPC service method.
   *
   * @param request the examples.movie_rating.MovieRating request message
   * @return a future of the examples.movie_rating.Empty response message
   */
  Future<examples.movie_rating.Empty> rateMovie(examples.movie_rating.MovieRating request);

  /**
   * Calls the GetMovieRating RPC service method.
   *
   * @param request the examples.movie_rating.MovieId request message
   * @return a future of the examples.movie_rating.MovieRatingDetails response message
   */
  Future<examples.movie_rating.MovieRatingDetails> getMovieRating(examples.movie_rating.MovieId request);
}
