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
public final class CrudKeyValueGrpc {

  private CrudKeyValueGrpc() {}

  public static final String SERVICE_NAME = "CrudKeyValue";

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
    if ((getSetMethod = CrudKeyValueGrpc.getSetMethod) == null) {
      synchronized (CrudKeyValueGrpc.class) {
        if ((getSetMethod = CrudKeyValueGrpc.getSetMethod) == null) {
          CrudKeyValueGrpc.getSetMethod = getSetMethod =
              io.grpc.MethodDescriptor.<com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "set"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.SetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new CrudKeyValueMethodDescriptorSupplier("set"))
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
    if ((getGetMethod = CrudKeyValueGrpc.getGetMethod) == null) {
      synchronized (CrudKeyValueGrpc.class) {
        if ((getGetMethod = CrudKeyValueGrpc.getGetMethod) == null) {
          CrudKeyValueGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new CrudKeyValueMethodDescriptorSupplier("get"))
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
    if ((getDelMethod = CrudKeyValueGrpc.getDelMethod) == null) {
      synchronized (CrudKeyValueGrpc.class) {
        if ((getDelMethod = CrudKeyValueGrpc.getDelMethod) == null) {
          CrudKeyValueGrpc.getDelMethod = getDelMethod =
              io.grpc.MethodDescriptor.<com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "del"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new CrudKeyValueMethodDescriptorSupplier("del"))
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
    if ((getDelVersMethod = CrudKeyValueGrpc.getDelVersMethod) == null) {
      synchronized (CrudKeyValueGrpc.class) {
        if ((getDelVersMethod = CrudKeyValueGrpc.getDelVersMethod) == null) {
          CrudKeyValueGrpc.getDelVersMethod = getDelVersMethod =
              io.grpc.MethodDescriptor.<com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers, com.ufu.sd.dbnosql.controller.Comunicacao.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "delVers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new CrudKeyValueMethodDescriptorSupplier("delVers"))
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
    if ((getTestAndSetMethod = CrudKeyValueGrpc.getTestAndSetMethod) == null) {
      synchronized (CrudKeyValueGrpc.class) {
        if ((getTestAndSetMethod = CrudKeyValueGrpc.getTestAndSetMethod) == null) {
          CrudKeyValueGrpc.getTestAndSetMethod = getTestAndSetMethod =
              io.grpc.MethodDescriptor.<com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest, com.ufu.sd.dbnosql.controller.Comunicacao.Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "testAndSet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ufu.sd.dbnosql.controller.Comunicacao.Reply.getDefaultInstance()))
              .setSchemaDescriptor(new CrudKeyValueMethodDescriptorSupplier("testAndSet"))
              .build();
        }
      }
    }
    return getTestAndSetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CrudKeyValueStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrudKeyValueStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrudKeyValueStub>() {
        @java.lang.Override
        public CrudKeyValueStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrudKeyValueStub(channel, callOptions);
        }
      };
    return CrudKeyValueStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CrudKeyValueBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrudKeyValueBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrudKeyValueBlockingStub>() {
        @java.lang.Override
        public CrudKeyValueBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrudKeyValueBlockingStub(channel, callOptions);
        }
      };
    return CrudKeyValueBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CrudKeyValueFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CrudKeyValueFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CrudKeyValueFutureStub>() {
        @java.lang.Override
        public CrudKeyValueFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CrudKeyValueFutureStub(channel, callOptions);
        }
      };
    return CrudKeyValueFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CrudKeyValueImplBase implements io.grpc.BindableService {

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
  public static final class CrudKeyValueStub extends io.grpc.stub.AbstractAsyncStub<CrudKeyValueStub> {
    private CrudKeyValueStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrudKeyValueStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrudKeyValueStub(channel, callOptions);
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
  public static final class CrudKeyValueBlockingStub extends io.grpc.stub.AbstractBlockingStub<CrudKeyValueBlockingStub> {
    private CrudKeyValueBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrudKeyValueBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrudKeyValueBlockingStub(channel, callOptions);
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
  public static final class CrudKeyValueFutureStub extends io.grpc.stub.AbstractFutureStub<CrudKeyValueFutureStub> {
    private CrudKeyValueFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CrudKeyValueFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CrudKeyValueFutureStub(channel, callOptions);
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
    private final CrudKeyValueImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CrudKeyValueImplBase serviceImpl, int methodId) {
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

  private static abstract class CrudKeyValueBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CrudKeyValueBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ufu.sd.dbnosql.controller.Comunicacao.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CrudKeyValue");
    }
  }

  private static final class CrudKeyValueFileDescriptorSupplier
      extends CrudKeyValueBaseDescriptorSupplier {
    CrudKeyValueFileDescriptorSupplier() {}
  }

  private static final class CrudKeyValueMethodDescriptorSupplier
      extends CrudKeyValueBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CrudKeyValueMethodDescriptorSupplier(String methodName) {
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
      synchronized (CrudKeyValueGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CrudKeyValueFileDescriptorSupplier())
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
