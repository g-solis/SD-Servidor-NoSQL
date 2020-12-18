package com.ufu.sd.dbnosql;
import com.google.protobuf.ByteString;
import com.ufu.sd.dbnosql.controller.*;
import com.ufu.sd.dbnosql.model.HashtableValue;
import com.ufu.sd.dbnosql.repository.DbNosqlRepository;
import io.grpc.stub.*;
import org.apache.ratis.client.RaftClient;
import org.apache.ratis.protocol.Message;
import org.apache.ratis.protocol.RaftClientReply;
import org.apache.ratis.statemachine.TransactionContext;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbNosqlService extends CrudKeyValueGrpc.CrudKeyValueImplBase{
    private static final Logger logger = Logger.getLogger(DbNosqlServer.class.getName());

    public RaftClient raftClient;

//    private ConcurrentHashMap<BigInteger, HashtableValue> hashtable;
//    private DbNosqlRepository dbNosqlRepository;

    public DbNosqlService() {
//        this.dbNosqlRepository = new DbNosqlRepository(dirHashtable);
//        this.hashtable = initializeHashtable();
    }

    @Override
    public void set(Comunicacao.SetRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {
        Comunicacao.Reply reply;
        HashtableValue htValue;


//        RaftClientReply rep = raftClient.send(Message.valueOf(ToByteString("Set:" + request.toString())));



//        BigInteger key = ToBigInteger(request.getKey().getValue());
//        long timestamp = request.getTimestamp();
//        byte[] data = request.getData().toByteArray();
//
//        htValue = hashtable.putIfAbsent(key, new HashtableValue(1,timestamp,data));
//
//        if(htValue == null) {
//            reply = CreateReply("SUCCESS");
//            SendReply(responseObserver, reply);
//        }
//        else {
//            reply = CreateReply("ERROR", htValue.version,htValue.timestamp,htValue.data);
//            SendReply(responseObserver, reply);
//        }
    }

    @Override
    public void get(Comunicacao.GetRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {
        Comunicacao.Reply reply;
        HashtableValue htValue;
//
//        BigInteger key = ToBigInteger(request.getKey().getValue());
//
//        htValue = hashtable.get(key);
//
//        if(htValue != null) {
//            reply = CreateReply("SUCCESS", htValue.version, htValue.timestamp, htValue.data);
//            SendReply(responseObserver, reply);
//        }
//        else {
//            reply = CreateReply("ERROR");
//            SendReply(responseObserver, reply);
//        }
    }

    @Override
    public void del(Comunicacao.DelRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {
        Comunicacao.Reply reply;
        HashtableValue htValue;
//
//        BigInteger key = ToBigInteger(request.getKey().getValue());
//
//        htValue = hashtable.remove(key);
//
//        if(htValue != null) {
//            reply = CreateReply("SUCCESS", htValue.version, htValue.timestamp, htValue.data);
//            SendReply(responseObserver, reply);
//        }
//        else {
//            reply = CreateReply("ERROR");
//            SendReply(responseObserver, reply);
//        }
    }

    @Override
    public void delVers(Comunicacao.DelRequestVers request,
                        StreamObserver<Comunicacao.Reply> responseObserver) {
        Comunicacao.Reply reply;
        HashtableValue htValue;

//        BigInteger key = ToBigInteger(request.getKey().getValue());
//
//        do {
//            htValue = hashtable.get(key);
//            if (htValue == null) {
//                reply = CreateReply("ERROR_NE");
//                SendReply(responseObserver, reply);
//                return;
//            }
//            if (htValue.version != request.getVersion()) {
//                reply = CreateReply("ERROR_WV", htValue.version, htValue.timestamp, htValue.data);
//                SendReply(responseObserver, reply);
//                return;
//            }
//        } while (!hashtable.remove(key, htValue));
//
//        reply = CreateReply("SUCCESS", htValue.version,htValue.timestamp,htValue.data);
//        SendReply(responseObserver, reply);
    }

    @Override
    public void testAndSet(Comunicacao.TestAndSetRequest request,
                           StreamObserver<Comunicacao.Reply> responseObserver) {
        Comunicacao.Reply reply;
        HashtableValue htValue;

//        Comunicacao.VTripla vTriple = request.getValue();
//        HashtableValue newHtValue = new HashtableValue(
//            vTriple.getVersion(),
//            vTriple.getTimestamp(),
//            ToByteArray(vTriple.getData())
//        );
//
//        BigInteger key = ToBigInteger(request.getKey().getValue());
//
//        do {
//            htValue = hashtable.get(key);
//            if (htValue == null) {
//                reply = CreateReply("ERROR_NE");
//                SendReply(responseObserver, reply);
//                return;
//            }
//            if (htValue.version != request.getVersion()) {
//                reply = CreateReply("ERROR_WV", htValue.version, htValue.timestamp, htValue.data);
//                SendReply(responseObserver, reply);
//                return;
//            }
//        } while (!hashtable.replace(key, htValue, newHtValue));
//
//        reply = CreateReply("SUCCESS", htValue.version, htValue.timestamp, htValue.data);
//        SendReply(responseObserver, reply);
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

    public ByteString ToByteString(BigInteger BigInt)
    {
        return ToByteString(ToByteArray(BigInt));
    }

    public ByteString ToByteString(byte[] ByteArray)
    {
        return ByteString.copyFrom(ByteArray);
    }

    public ByteString ToByteString(String Str) { return ToByteString(Str.getBytes()); }

    public byte[] ToByteArray(BigInteger BigInt)
    {
        return BigInt.toByteArray();
    }

    public byte[] ToByteArray(ByteString ByteStr)
    {
        return ByteStr.toByteArray();
    }

    public BigInteger ToBigInteger(byte[] ByteArray)
    {
        return new BigInteger(ByteArray);
    }

    public BigInteger ToBigInteger(ByteString ByteStr)
    {
        return ToBigInteger(ToByteArray(ByteStr));
    }
}
