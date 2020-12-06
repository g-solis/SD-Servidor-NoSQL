package com.ufu.sd.dbnosql;

import com.google.protobuf.ByteString;
import com.ufu.sd.dbnosql.controller.Comunicacao;
import com.ufu.sd.dbnosql.controller.CrudKeyValueGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientService {
    private static final Logger logger = Logger.getLogger(ClientService.class.getName());

  private final CrudKeyValueGrpc.CrudKeyValueBlockingStub blockingStub;

  public ClientService(Channel channel) {
    blockingStub = CrudKeyValueGrpc.newBlockingStub(channel);
  }

  public void set(byte[] key, long ts, byte[] data) {
    Comunicacao.SetRequest request;
    Comunicacao.BigInteger keyBigInteger;

    keyBigInteger = Comunicacao.BigInteger
            .newBuilder()
            .setValue(ByteString.copyFrom(key))
            .build();

    request = Comunicacao.SetRequest
            .newBuilder()
            .setKey(keyBigInteger)
            .setTimestamp(ts)
            .setData(ByteString.copyFrom(data))
            .build();

    Comunicacao.Reply response;
    try {
      response = blockingStub.set(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("set: " + response);
  }

  public void get(byte[] key) {
    Comunicacao.GetRequest request;
    Comunicacao.BigInteger keyBigInteger;

    keyBigInteger = Comunicacao.BigInteger
            .newBuilder()
            .setValue(ByteString.copyFrom(key))
            .build();

    request = Comunicacao.GetRequest
            .newBuilder()
            .setKey(keyBigInteger)
            .build();

    Comunicacao.Reply response;
    try {
      response = blockingStub.get(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("get: " + response);
  }

  public void del(byte[] key) {
    Comunicacao.DelRequest request;
    Comunicacao.BigInteger keyBigInteger;

    keyBigInteger = Comunicacao.BigInteger
            .newBuilder()
            .setValue(ByteString.copyFrom(key))
            .build();

    request = Comunicacao.DelRequest
            .newBuilder()
            .setKey(keyBigInteger)
            .build();

    Comunicacao.Reply response;
    try {
      response = blockingStub.del(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("del: " + response);
  }

  public void delVers(byte[] key, long version) {
    Comunicacao.DelRequestVers request;
    Comunicacao.BigInteger keyBigInteger;

    keyBigInteger = Comunicacao.BigInteger
            .newBuilder()
            .setValue(ByteString.copyFrom(key))
            .build();

    request = Comunicacao.DelRequestVers
            .newBuilder()
            .setKey(keyBigInteger)
            .setVersion(version)
            .build();

    Comunicacao.Reply response;
    try {
      response = blockingStub.delVers(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("delVers: " + response);
  }

  public void testAndSet(byte[] key, long version, long ts, byte[] data, long vers) {
    Comunicacao.VTripla vTripla;
    Comunicacao.TestAndSetRequest request;
    Comunicacao.BigInteger keyBigInteger;

    keyBigInteger = Comunicacao.BigInteger
            .newBuilder()
            .setValue(ByteString.copyFrom(key))
            .build();

    vTripla = Comunicacao.VTripla
            .newBuilder().setVersion(version)
            .setTimestamp(ts)
            .setData(ByteString.copyFrom(data))
            .build();

    request = Comunicacao.TestAndSetRequest.newBuilder()
            .setKey(keyBigInteger)
            .setValue(vTripla)
            .setVersion(vers)
            .build();

    Comunicacao.Reply response;
    try {
      response = blockingStub.testAndSet(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("testAndSet: " + response);
  }

  public static void main(String[] args) throws Exception {
    String target = "localhost:8980";

    ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
        .usePlaintext()
        .build();

    try {
      ClientService client2 = new ClientService(channel);
      byte[] key = "005".getBytes();
      byte[] data = "Four".getBytes();

      client2.set(key, 777, data);
//      client2.get(key);
//      client2.del(key);
//      client2.delVers(key,1);
//      client2.testAndSet(key,3,588,data,5);

    } finally {
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
