package examples.movie_rating;

import io.vertx.core.Future;
import io.vertx.core.Promise;
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
 * <p>Contract definition MovieRatingDatabase service.</p>
 */
public interface MovieRatingDatabase {

  Future<examples.movie_rating.MovieDetails> getMovieDetails(examples.movie_rating.MovieId request);

  Future<examples.movie_rating.Empty> rateMovie(examples.movie_rating.MovieRating request);

  Future<examples.movie_rating.MovieRatingDetails> getMovieRating(examples.movie_rating.MovieId request);

}
