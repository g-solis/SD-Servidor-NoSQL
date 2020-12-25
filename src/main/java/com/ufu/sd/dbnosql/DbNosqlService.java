package com.ufu.sd.dbnosql;
//import com.google.protobuf.ByteString;
import org.apache.ratis.protocol.RaftClientReply;
import org.apache.ratis.thirdparty.com.google.protobuf.ByteString;

import java.nio.charset.Charset;
import java.util.Objects;
import java.util.function.Supplier;
import com.ufu.sd.dbnosql.controller.*;
import com.ufu.sd.dbnosql.model.HashtableValue;
import io.grpc.stub.*;
import org.apache.ratis.client.RaftClient;
import org.apache.ratis.protocol.Message;

import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Logger;

public class DbNosqlService extends CrudKeyValueGrpc.CrudKeyValueImplBase{
    public RaftClient raftClient;

    public DbNosqlService() { }

    @Override
    public void set(Comunicacao.SetRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {
        Comunicacao.Reply reply;

        BigInteger key = ToBigInteger(request.getKey().getValue());
        long timestamp = request.getTimestamp();
        byte[] data = request.getData().toByteArray();

        String requestMessage = "set:" + new String(key.toByteArray()) + ":" + timestamp + ":" + new String(data);

        RaftClientReply getValue = null;
        try {
            getValue = raftClient.send(Message.valueOf(requestMessage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] responses = getValue.getMessage().getContent().toString(Charset.defaultCharset()).split(":");

        if (Objects.equals(responses[0], "SUCCESS")) {
            reply = CreateReply("SUCCESS");
            SendReply(responseObserver, reply);
        }
        else {
            reply = CreateReply("ERROR", Long.parseLong(responses[1]), Long.parseLong(responses[2]), responses[3].getBytes());
            SendReply(responseObserver, reply);
        }
    }

    @Override
    public void get(Comunicacao.GetRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {
        Comunicacao.Reply reply;

        BigInteger key = ToBigInteger(request.getKey().getValue());

        RaftClientReply getValue = null;
        try {
            getValue = raftClient.sendReadOnly(Message.valueOf(new String(key.toByteArray())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] responses = getValue.getMessage().getContent().toString(Charset.defaultCharset()).split(":");

        if (Objects.equals(responses[0], "SUCCESS")) {
            reply = CreateReply("SUCCESS", Long.parseLong(responses[1]), Long.parseLong(responses[2]), responses[3].getBytes());
            SendReply(responseObserver, reply);
        }
        else {
            reply = CreateReply("ERROR");
            SendReply(responseObserver, reply);
        }
    }

    @Override
    public void del(Comunicacao.DelRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {
        Comunicacao.Reply reply;

        BigInteger key = ToBigInteger(request.getKey().getValue());

        String requestMessage = "del:" + new String(key.toByteArray());

        RaftClientReply getValue = null;
        try {
            getValue = raftClient.send(Message.valueOf(requestMessage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] responses = getValue.getMessage().getContent().toString(Charset.defaultCharset()).split(":");

        if (Objects.equals(responses[0], "SUCCESS")) {
            reply = CreateReply("SUCCESS", Long.parseLong(responses[1]), Long.parseLong(responses[2]), responses[3].getBytes());
            SendReply(responseObserver, reply);
        }
        else {
            reply = CreateReply("ERROR");
            SendReply(responseObserver, reply);
        }
    }

    @Override
    public void delVers(Comunicacao.DelRequestVers request,
                        StreamObserver<Comunicacao.Reply> responseObserver) {
        Comunicacao.Reply reply;

        BigInteger key = ToBigInteger(request.getKey().getValue());
        long version = request.getVersion();

        String requestMessage = "delVers:" + new String(key.toByteArray()) + ":" + version;

        RaftClientReply getValue = null;
        try {
            getValue = raftClient.send(Message.valueOf(requestMessage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] responses = getValue.getMessage().getContent().toString(Charset.defaultCharset()).split(":");

        if (Objects.equals(responses[0], "ERROR_NE")) {
            reply = CreateReply("ERROR_NE");
            SendReply(responseObserver, reply);
        }
        else {
            reply = CreateReply(responses[0], Long.parseLong(responses[1]), Long.parseLong(responses[2]), responses[3].getBytes());
            SendReply(responseObserver, reply);
        }
    }

    @Override
    public void testAndSet(Comunicacao.TestAndSetRequest request,
                           StreamObserver<Comunicacao.Reply> responseObserver) {
        Comunicacao.Reply reply;

        Comunicacao.VTripla vTriple = request.getValue();

        BigInteger key = ToBigInteger(request.getKey().getValue());
        long version = request.getVersion();
        byte[] data = vTriple.getData().toByteArray();

        String requestMessage = "testAndSet:" +
                new String(key.toByteArray()) + ":" +
                vTriple.getVersion() + ":" +
                vTriple.getTimestamp() + ":" +
                new String(data) + ":" +
                version;

        RaftClientReply getValue = null;
        try {
            getValue = raftClient.send(Message.valueOf(requestMessage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] responses = getValue.getMessage().getContent().toString(Charset.defaultCharset()).split(":");

        if (Objects.equals(responses[0], "ERROR_NE")) {
            reply = CreateReply("ERROR_NE");
            SendReply(responseObserver, reply);
        }
        else {
            reply = CreateReply(responses[0], Long.parseLong(responses[1]), Long.parseLong(responses[2]), responses[3].getBytes());
            SendReply(responseObserver, reply);
        }
    }

    public Comunicacao.VTripla CreateVTripla(long Version, long Timestamp, byte[] Data) {
        Comunicacao.VTripla.Builder vt = Comunicacao.VTripla.newBuilder();
        vt.setVersion(Version);
        vt.setTimestamp(Timestamp);
        vt.setData(ToByteString(Data));
        return vt.build();
    }

    public Comunicacao.Reply CreateReply(String ErrorCode, long Version, long Timestamp, byte[] Data) {
        Comunicacao.Reply.Builder rp = Comunicacao.Reply.newBuilder();
        rp.setError(ErrorCode);
        rp.setValue(CreateVTripla(Version,Timestamp,Data));
        return rp.build();
    }

    public Comunicacao.Reply CreateReply(String ErrorCode) {
        Comunicacao.Reply.Builder rp = Comunicacao.Reply.newBuilder();
        rp.setError(ErrorCode);
        return rp.build();
    }

    public void SendReply(StreamObserver<Comunicacao.Reply> responseObserver, Comunicacao.Reply Reply) {
        responseObserver.onNext(Reply);
        responseObserver.onCompleted();
    }

    public com.google.protobuf.ByteString ToByteString(byte[] ByteArray) {
        return com.google.protobuf.ByteString.copyFrom(ByteArray);
    }

    public BigInteger ToBigInteger(com.google.protobuf.ByteString ByteStr) {
        return new BigInteger(ByteStr.toByteArray());
    }
}
