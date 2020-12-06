package com.ufu.sd.dbnosql;

import com.google.protobuf.ByteString;
import com.ufu.sd.dbnosql.controller.Comunicacao;
import com.ufu.sd.dbnosql.controller.CrudKeyValueGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootTest
class ClientServiceTests {
    private static final Logger logger = Logger.getLogger(ClientService.class.getName());

    private final CrudKeyValueGrpc.CrudKeyValueBlockingStub blockingStub;

    public ClientServiceTests(Channel channel) {
        blockingStub = CrudKeyValueGrpc.newBlockingStub(channel);
    }

    public Comunicacao.Reply set(byte[] key, long ts, byte[] data) {
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
            return blockingStub.set(request);
        } catch (StatusRuntimeException e) {
            return null;
        }
    }

    public Comunicacao.Reply get(byte[] key) {
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
            return blockingStub.get(request);
        } catch (StatusRuntimeException e) {
            return null;
        }
    }

    public Comunicacao.Reply del(byte[] key) {
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
            return blockingStub.del(request);
        } catch (StatusRuntimeException e) {
            return null;
        }
    }

    public Comunicacao.Reply delVers(byte[] key, long version) {
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
            return blockingStub.delVers(request);
        } catch (StatusRuntimeException e) {
            return null;
        }
    }

    public Comunicacao.Reply testAndSet(byte[] key, long version, long ts, byte[] data, long vers) {
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
            return blockingStub.testAndSet(request);
        } catch (StatusRuntimeException e) {
            return null;
        }
    }

    @Test
    public static void main(String[] args) throws Exception {
        String target = "localhost:8980";

        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();

        try {
            Logger.getLogger("io.grpc").setLevel(Level.WARNING);

            ClientServiceTests client2 = new ClientServiceTests(channel);
            byte[] data = "Data Test".getBytes();

            Comunicacao.Reply response;
            client2.set("002".getBytes(), 00000, data); //AUX
            client2.set("003".getBytes(), 00000, data); //AUX

            response = client2.set("001".getBytes(), 00001, data); //success
            LogError(response, "Set Data in 001");

            response = client2.set("001".getBytes(), 00002, data); //error
            LogError(response, "Set Data in 001");

            response = client2.get("001".getBytes()); //success
            LogError(response, "Get Data from 001");

            response = client2.get("00x".getBytes()); //error
            LogError(response, "Get Data from 00x");

            response = client2.del("001".getBytes()); //success
            LogError(response, "Delete Data from 001");

            response = client2.del("00x".getBytes()); //error
            LogError(response, "Delete Data from 00x");

            response = client2.delVers("002".getBytes(), 2); //error WV
            LogError(response, "Delete(Version 2) Data from 002"," WV");

            response = client2.delVers("002".getBytes(), 1); //success
            LogError(response, "Delete(Version 1) Data from 002");

            response = client2.delVers("00x".getBytes(), 1); //error NE
            LogError(response, "Delete(Version 1) Data from 00x");

            response = client2.testAndSet("003".getBytes(),2,00003, data, 1); //success
            LogError(response, "TestAndSet(Version 1) Data from 003");

            response = client2.testAndSet("003".getBytes(),2,00004, data, 3); //error WV
            LogError(response, "TestAndSet(Version 3) Data from 003"," WV");

            response = client2.testAndSet("00x".getBytes(),3,00005, data, 5); //error NE
            LogError(response, "TestAndSet(Version 5) Data from 00x"," NE");

            String str;
            byte[] strBytes;

            for (int i = 0; i <= 1000; i++) {
                str = "00"+i;
                strBytes = str.getBytes();

                Comunicacao.Reply responseT = client2.set(strBytes, i, strBytes);
                LogError(responseT, String.format("Set Data in %4.0f", (float) i));
            }

        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    private static void LogError(Comunicacao.Reply Reply, String PreMessage,String PostMessage)
    {
        logger.info(PreMessage + " - " + (Objects.equals(Reply.getError(), "SUCCESS") ? "Success" : "Error") + PostMessage);
    }

    private static void LogError(Comunicacao.Reply Reply, String PreMessage)
    {
        LogError(Reply,PreMessage,"");
    }
}
