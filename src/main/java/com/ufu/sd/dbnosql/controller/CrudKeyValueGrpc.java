package com.ufu.sd.dbnosql.controller;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.1)",
    comments = "Source: Comunicacao.proto")
public final class CrudkeyValueGrpc {

  private CrudkeyValueGrpc() {}

  public static final String SERVICE_NAME = "CrudkeyValue";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest,
      com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "set",
      requestType = com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest.class,
      responseType = com.ufu.sd.dbnosql.controller.Comunicacao.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest,
      com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getSetMethod() {
    io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getSetMethod;
    if ((getSetMethod = CrudkeyValueGrpc.getSetMethod) == null) {
      synchronized (CrudkeyValueGrpc.class) {
        if ((getSetMethod = CrudkeyValueGrpc.getSetMethod) == null) {
          CrudkeyValueGrpc.getSetMethod = getSetMethod =
              io.grpc.MethodDescriptor.<com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "set"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new CrudkeyValueMethodDescriptorSupplier("set"))
              .build();
        }
      }
    }
    return getSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest,
      com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "get",
      requestType = com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest.class,
      responseType = com.ufu.sd.dbnosql.controller.Comunicacao.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest,
      com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getGetMethod() {
    io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getGetMethod;
    if ((getGetMethod = CrudkeyValueGrpc.getGetMethod) == null) {
      synchronized (CrudkeyValueGrpc.class) {
        if ((getGetMethod = CrudkeyValueGrpc.getGetMethod) == null) {
          CrudkeyValueGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new CrudkeyValueMethodDescriptorSupplier("get"))
              .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest,
      com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getDelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "del",
      requestType = com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest.class,
      responseType = com.ufu.sd.dbnosql.controller.Comunicacao.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest,
      com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getDelMethod() {
    io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getDelMethod;
    if ((getDelMethod = CrudkeyValueGrpc.getDelMethod) == null) {
      synchronized (CrudkeyValueGrpc.class) {
        if ((getDelMethod = CrudkeyValueGrpc.getDelMethod) == null) {
          CrudkeyValueGrpc.getDelMethod = getDelMethod =
              io.grpc.MethodDescriptor.<com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "del"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new CrudkeyValueMethodDescriptorSupplier("del"))
              .build();
        }
      }
    }
    return getDelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers,
      com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getDelVersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delVers",
      requestType = com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers.class,
      responseType = com.ufu.sd.dbnosql.controller.Comunicacao.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers,
      com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getDelVersMethod() {
    io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers, com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getDelVersMethod;
    if ((getDelVersMethod = CrudkeyValueGrpc.getDelVersMethod) == null) {
      synchronized (CrudkeyValueGrpc.class) {
        if ((getDelVersMethod = CrudkeyValueGrpc.getDelVersMethod) == null) {
          CrudkeyValueGrpc.getDelVersMethod = getDelVersMethod =
              io.grpc.MethodDescriptor.<com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers, com.ufu.sd.dbnosql.controller.Comunicacao.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "delVers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new CrudkeyValueMethodDescriptorSupplier("delVers"))
              .build();
        }
      }
    }
    return getDelVersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest,
      com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getTestAndSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "testAndSet",
      requestType = com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest.class,
      responseType = com.ufu.sd.dbnosql.controller.Comunicacao.Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest,
      com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getTestAndSetMethod() {
    io.grpc.MethodDescriptor<com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply> getTestAndSetMethod;
    if ((getTestAndSetMethod = CrudkeyValueGrpc.getTestAndSetMethod) == null) {
      synchronized (CrudkeyValueGrpc.class) {
        if ((getTestAndSetMethod = CrudkeyValueGrpc.getTestAndSetMethod) == null) {
          CrudkeyValueGrpc.getTestAndSetMethod = getTestAndSetMethod =
              io.grpc.MethodDescriptor.<com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "testAndSet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new CrudkeyValueMethodDescriptorSupplier("testAndSet"))
              .build();
        }
      }
    }
    return getTestAndSetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CrudkeyValueStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrudkeyValueStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrudkeyValueStub>() {
        @java.lang.Override
        public CrudkeyValueStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrudkeyValueStub(channel, callOptions);
        }
      };
    return CrudkeyValueStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CrudkeyValueBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrudkeyValueBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrudkeyValueBlockingStub>() {
        @java.lang.Override
        public CrudkeyValueBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrudkeyValueBlockingStub(channel, callOptions);
        }
      };
    return CrudkeyValueBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CrudkeyValueFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrudkeyValueFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrudkeyValueFutureStub>() {
        @java.lang.Override
        public CrudkeyValueFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrudkeyValueFutureStub(channel, callOptions);
        }
      };
    return CrudkeyValueFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CrudkeyValueImplBase implements io.grpc.BindableService {

    /**
     */
    public void set(com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest request,
        io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getSetMethod(), responseObserver);
    }

    /**
     */
    public void get(com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest request,
        io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     */
    public void del(com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest request,
        io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getDelMethod(), responseObserver);
    }

    /**
     */
    public void delVers(com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers request,
        io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getDelVersMethod(), responseObserver);
    }

    /**
     */
    public void testAndSet(com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest request,
        io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getTestAndSetMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest,
                com.ufu.sd.dbnosql.controller.Comunicacao.Reply>(
                  this, METHODID_SET)))
          .addMethod(
            getGetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest,
                com.ufu.sd.dbnosql.controller.Comunicacao.Reply>(
                  this, METHODID_GET)))
          .addMethod(
            getDelMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest,
                com.ufu.sd.dbnosql.controller.Comunicacao.Reply>(
                  this, METHODID_DEL)))
          .addMethod(
            getDelVersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers,
                com.ufu.sd.dbnosql.controller.Comunicacao.Reply>(
                  this, METHODID_DEL_VERS)))
          .addMethod(
            getTestAndSetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest,
                com.ufu.sd.dbnosql.controller.Comunicacao.Reply>(
                  this, METHODID_TEST_AND_SET)))
          .build();
    }
  }

  /**
   */
  public static final class CrudkeyValueStub extends io.grpc.stub.AbstractAsyncStub<CrudkeyValueStub> {
    private CrudkeyValueStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrudkeyValueStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrudkeyValueStub(channel, callOptions);
    }

    /**
     */
    public void set(com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest request,
        io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get(com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest request,
        io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void del(com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest request,
        io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delVers(com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers request,
        io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDelVersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void testAndSet(com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest request,
        io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestAndSetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CrudkeyValueBlockingStub extends io.grpc.stub.AbstractBlockingStub<CrudkeyValueBlockingStub> {
    private CrudkeyValueBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrudkeyValueBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrudkeyValueBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.ufu.sd.dbnosql.controller.Comunicacao.Reply set(com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ufu.sd.dbnosql.controller.Comunicacao.Reply get(com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ufu.sd.dbnosql.controller.Comunicacao.Reply del(com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest request) {
      return blockingUnaryCall(
          getChannel(), getDelMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ufu.sd.dbnosql.controller.Comunicacao.Reply delVers(com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers request) {
      return blockingUnaryCall(
          getChannel(), getDelVersMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.ufu.sd.dbnosql.controller.Comunicacao.Reply testAndSet(com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestAndSetMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CrudkeyValueFutureStub extends io.grpc.stub.AbstractFutureStub<CrudkeyValueFutureStub> {
    private CrudkeyValueFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrudkeyValueFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrudkeyValueFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> set(
        com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> get(
        com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> del(
        com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> delVers(
        com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers request) {
      return futureUnaryCall(
          getChannel().newCall(getDelVersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> testAndSet(
        com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestAndSetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET = 0;
  private static final int METHODID_GET = 1;
  private static final int METHODID_DEL = 2;
  private static final int METHODID_DEL_VERS = 3;
  private static final int METHODID_TEST_AND_SET = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CrudkeyValueImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CrudkeyValueImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET:
          serviceImpl.set((com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest) request,
              (io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest) request,
              (io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply>) responseObserver);
          break;
        case METHODID_DEL:
          serviceImpl.del((com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest) request,
              (io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply>) responseObserver);
          break;
        case METHODID_DEL_VERS:
          serviceImpl.delVers((com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers) request,
              (io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply>) responseObserver);
          break;
        case METHODID_TEST_AND_SET:
          serviceImpl.testAndSet((com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest) request,
              (io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply>) responseObserver);
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

  private static abstract class CrudkeyValueBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CrudkeyValueBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ufu.sd.dbnosql.controller.Comunicacao.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CrudkeyValue");
    }
  }

  private static final class CrudkeyValueFileDescriptorSupplier
      extends CrudkeyValueBaseDescriptorSupplier {
    CrudkeyValueFileDescriptorSupplier() {}
  }

  private static final class CrudkeyValueMethodDescriptorSupplier
      extends CrudkeyValueBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CrudkeyValueMethodDescriptorSupplier(String methodName) {
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
      synchronized (CrudkeyValueGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CrudkeyValueFileDescriptorSupplier())
              .addMethod(getSetMethod())
              .addMethod(getGetMethod())
              .addMethod(getDelMethod())
              .addMethod(getDelVersMethod())
              .addMethod(getTestAndSetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
