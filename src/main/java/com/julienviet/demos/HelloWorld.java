package com.julienviet.demos;

import com.julienviet.demos.greeter.GreeterGrpc;
import com.julienviet.demos.greeter.GreeterGrpcService;
import com.julienviet.demos.greeter.HelloReply;
import com.julienviet.demos.greeter.HelloRequest;
import io.grpc.stub.StreamObserver;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.grpc.reflection.ReflectionService;
import io.vertx.grpcio.server.GrpcIoServer;

public class HelloWorld {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    HttpServer httpServer = vertx.createHttpServer();
    GrpcIoServer grpcServer = GrpcIoServer.server(vertx);
    grpcServer.addService(ReflectionService.v1());

    grpcServer.addService(new GreeterGrpc.GreeterImplBase() {
      @Override
      public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        responseObserver.onNext(HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
        responseObserver.onCompleted();
      }
    });

/*
    grpcServer.addService(new GreeterGrpcService() {
      @Override
      public Future<HelloReply> sayHello(HelloRequest request) {

        return vertx
          .timer(200) // Should be a database interaction
          .map(v -> HelloReply.newBuilder().setMessage("Hello " + request.getName()).build());
      }
    });
*/

    httpServer
      .requestHandler(grpcServer)
      .listen(8080, "localhost")
      .await();
  }


  // grpcurl -plaintext localhost:8080 list
  // grpcurl -plaintext localhost:8080 list examples.grpc.Greeter
  // grpcurl -plaintext localhost:8080 list examples.grpc.Greeter
  // grpcurl -plaintext localhost:8080 describe examples.grpc.Greeter
  // grpcurl -plaintext -d '{"name": "Julien"}' localhost:8080 examples.grpc.Greeter/SayHello
  // curl --header "Content-Type: application/json" --request POST --data '{"name":"Julien"}' http://localhost:8080/examples.grpc.Greeter/SayHello

}
