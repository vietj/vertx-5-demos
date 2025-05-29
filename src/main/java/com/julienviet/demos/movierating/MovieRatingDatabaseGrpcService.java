package com.julienviet.demos.movierating;

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
import io.vertx.grpc.server.StatusException;

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
public class MovieRatingDatabaseGrpcService extends MovieRatingDatabaseService implements Service {

  /**
   * MovieRatingDatabase service name.
   */
  public static final ServiceName SERVICE_NAME = ServiceName.create("examples.grpc", "MovieRatingDatabase");

  /**
   * MovieRatingDatabase service descriptor.
   */
  public static final Descriptors.ServiceDescriptor SERVICE_DESCRIPTOR = MovieRatingOuterClass.getDescriptor().findServiceByName("MovieRatingDatabase");

  @Override
  public ServiceName name() {
    return SERVICE_NAME;
  }

  @Override
  public Descriptors.ServiceDescriptor descriptor() {
    return SERVICE_DESCRIPTOR;
  }

  @Override
  public void bind(GrpcServer server) {
    builder(this).bind(all()).build().bind(server);
  }

  /**
   * @return a service binding all methods of the given {@code service}
   */
  public static Service of(MovieRatingDatabaseService service) {
    return builder(service).bind(all()).build();
  }

  /**
   * GetMovieDetails protobuf RPC server service method.
   */
  public static final ServiceMethod<com.julienviet.demos.movierating.MovieId, com.julienviet.demos.movierating.MovieDetails> GetMovieDetails = ServiceMethod.server(
    SERVICE_NAME,
    "GetMovieDetails",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.julienviet.demos.movierating.MovieId.newBuilder()));

  /**
   * RateMovie protobuf RPC server service method.
   */
  public static final ServiceMethod<com.julienviet.demos.movierating.MovieRating, com.julienviet.demos.movierating.Empty> RateMovie = ServiceMethod.server(
    SERVICE_NAME,
    "RateMovie",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.julienviet.demos.movierating.MovieRating.newBuilder()));

  /**
   * GetMovieRating protobuf RPC server service method.
   */
  public static final ServiceMethod<com.julienviet.demos.movierating.MovieId, com.julienviet.demos.movierating.MovieRatingDetails> GetMovieRating = ServiceMethod.server(
    SERVICE_NAME,
    "GetMovieRating",
    GrpcMessageEncoder.encoder(),
    GrpcMessageDecoder.decoder(com.julienviet.demos.movierating.MovieId.newBuilder()));

  /**
   * @return a mutable list of the known protobuf RPC server service methods.
   */
  public static java.util.List<ServiceMethod<?, ?>> all() {
    java.util.List<ServiceMethod<?, ?>> all = new java.util.ArrayList<>();
    all.add(GetMovieDetails);
    all.add(RateMovie);
    all.add(GetMovieRating);
    return all;
  }


  /**
   * @return a free form builder that gives the opportunity to bind only certain methods of a service
   */
  public static Builder builder(MovieRatingDatabaseService service) {
    return new Builder(service);
  }

  /**
   * Service builder.
   */
  public static class Builder implements ServiceBuilder {

    private final List<ServiceMethod<?, ?>> serviceMethods = new ArrayList<>();
    private final MovieRatingDatabaseService instance;

    private Builder(MovieRatingDatabaseService instance) {
      this.instance = instance;
    }

//    private void validate() {
//      for (ServiceMethod<?, ?> serviceMethod : serviceMethods) {
//        if (resolveHandler(serviceMethod) == null) {
//          throw new IllegalArgumentException("Invalid service method:" + serviceMethod);
//        }
//      }
//    }

    /**
     * Throws {@code UnsupportedOperationException}.
     */
    public <Req, Resp> ServiceBuilder bind(ServiceMethod<Req, Resp> serviceMethod, Handler<GrpcServerRequest<Req, Resp>> handler) {
      throw new UnsupportedOperationException();
    }

    /**
     * @return this builder
     */
    public Builder bind(List<ServiceMethod<?, ?>> methods) {
      serviceMethods.addAll(methods);
      return this;
    }

    /**
     * @return this builder
     */
    public Builder bind(ServiceMethod<?, ?>... methods) {
      return bind(java.util.Arrays.asList(methods));
    }

    public Service build() {
      return new Invoker();
    }

    private class Invoker implements Service {

      // Defensive copy
      private final List<ServiceMethod<?, ?>> serviceMethods = new ArrayList<>(Builder.this.serviceMethods);

      public ServiceName name() {
        return SERVICE_NAME;
      }

      public Descriptors.ServiceDescriptor descriptor() {
        return SERVICE_DESCRIPTOR;
      }

      /**
       * Bind the contained service methods to the {@code server}.
       */
      public void bind(GrpcServer server) {
        for (ServiceMethod<?, ?> serviceMethod : serviceMethods) {
          bindHandler(serviceMethod, server);
        }
      }

      private <Req, Resp> void bindHandler(ServiceMethod<Req, Resp> serviceMethod, GrpcServer server) {
        Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>> handler = resolveHandler(serviceMethod);
        server.callHandler(serviceMethod, handler);
      }

      private <Req, Resp> Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>> resolveHandler(ServiceMethod<Req, Resp> serviceMethod) {
        if (GetMovieDetails == serviceMethod) {
          Handler<io.vertx.grpc.server.GrpcServerRequest<com.julienviet.demos.movierating.MovieId, com.julienviet.demos.movierating.MovieDetails>> handler = this::handle_getMovieDetails;
          Handler<?> handler2 = handler;
          return (Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>>) handler2;
        }
        if (RateMovie == serviceMethod) {
          Handler<io.vertx.grpc.server.GrpcServerRequest<com.julienviet.demos.movierating.MovieRating, com.julienviet.demos.movierating.Empty>> handler = this::handle_rateMovie;
          Handler<?> handler2 = handler;
          return (Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>>) handler2;
        }
        if (GetMovieRating == serviceMethod) {
          Handler<io.vertx.grpc.server.GrpcServerRequest<com.julienviet.demos.movierating.MovieId, com.julienviet.demos.movierating.MovieRatingDetails>> handler = this::handle_getMovieRating;
          Handler<?> handler2 = handler;
          return (Handler<io.vertx.grpc.server.GrpcServerRequest<Req, Resp>>) handler2;
        }
        return null;
      }


  private void handle_getMovieDetails(io.vertx.grpc.server.GrpcServerRequest<com.julienviet.demos.movierating.MovieId, com.julienviet.demos.movierating.MovieDetails> request) {
    request.handler(msg -> {
      instance.getMovieDetails(msg, (res, err) -> {
        if (err == null) {
          request.response().end(res);
        } else {
          request.response().fail(err);
        }
      });
    });
  }

  private void handle_rateMovie(io.vertx.grpc.server.GrpcServerRequest<com.julienviet.demos.movierating.MovieRating, com.julienviet.demos.movierating.Empty> request) {
    request.handler(msg -> {
      instance.rateMovie(msg, (res, err) -> {
        if (err == null) {
          request.response().end(res);
        } else {
          request.response().fail(err);
        }
      });
    });
  }

  private void handle_getMovieRating(io.vertx.grpc.server.GrpcServerRequest<com.julienviet.demos.movierating.MovieId, com.julienviet.demos.movierating.MovieRatingDetails> request) {
    request.handler(msg -> {
      instance.getMovieRating(msg, (res, err) -> {
        if (err == null) {
          request.response().end(res);
        } else {
          request.response().fail(err);
        }
      });
    });
  }
    }
  }
}
