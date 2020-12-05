package com.ufu.sd.dbnosql;
import com.google.protobuf.ByteString;
import com.ufu.sd.dbnosql.controller.*;
import com.ufu.sd.dbnosql.model.HashtableValue;
import com.ufu.sd.dbnosql.repository.DbNosqlRepository;
import io.grpc.stub.*;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbNosqlService extends CrudKeyValueGrpc.CrudKeyValueImplBase{
    private static final Logger logger = Logger.getLogger(DbNosqlServer.class.getName());

    private Hashtable<BigInteger, HashtableValue> hashtable;
    private DbNosqlRepository dbNosqlRepository;

    public DbNosqlService(String dirHashtable) {
        this.dbNosqlRepository = new DbNosqlRepository(dirHashtable);
        this.hashtable = initializeHashtable();
    }

    @Override
    public void set(Comunicacao.SetRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {
        Comunicacao.Reply reply;
        BigInteger key = ToBigInteger(request.getKey().getValue());

        if(hashtable.containsKey(key)) {
            HashtableValue htValue =  hashtable.get(key);

            reply = CreateReply("ERROR", htValue.version,htValue.timestamp,htValue.data);
            SendReply(responseObserver, reply);

        }
        else {
            long timestamp = request.getTimestamp();
            byte[] data = request.getData().toByteArray();

            hashtable.put(key, new HashtableValue(1,timestamp,data));

            reply = CreateReply("SUCCESS",1,timestamp,data);
            SendReply(responseObserver, reply);

            writeHashtableFile(hashtable);
        }
    }

    @Override
    public void get(Comunicacao.GetRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {

        BigInteger key = ToBigInteger(request.getKey().getValue());

        Comunicacao.Reply rp = null;

        if(hashtable.containsKey(key)) {
            HashtableValue htValue =  hashtable.get(key);

            rp = CreateReply("SUCCESS", htValue.version,htValue.timestamp,htValue.data);
        }
        else {
            rp = CreateReply("ERROR");
        }

        SendReply(responseObserver, rp);
    }

    @Override
    public void del(Comunicacao.DelRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {

        BigInteger key = ToBigInteger(request.getKey().getValue());

        Comunicacao.Reply rp = null;

        if(hashtable.containsKey(key)) {
            HashtableValue htValue =  hashtable.remove(key);

            rp = CreateReply("SUCCESS", htValue.version,htValue.timestamp,htValue.data);
        }
        else {
            rp = CreateReply("ERROR");
        }

        SendReply(responseObserver, rp);
    }

    @Override
    public void delVers(Comunicacao.DelRequestVers request,
                        StreamObserver<Comunicacao.Reply> responseObserver) {

        BigInteger key = ToBigInteger(request.getKey().getValue());

        Comunicacao.Reply rp = null;

        if(hashtable.containsKey(key)) {
            HashtableValue htValue = hashtable.get(key);

            if(htValue.version == request.getVersion()) {
                hashtable.remove(key);

                rp = CreateReply("SUCCESS", htValue.version,htValue.timestamp,htValue.data);
            }
            else {
                rp = CreateReply("ERROR_WV", htValue.version,htValue.timestamp,htValue.data);
            }
        }
        else {
            rp = CreateReply("ERROR_NE");
        }

        SendReply(responseObserver, rp);

    }

    @Override
    public void testAndSet(Comunicacao.TestAndSetRequest request,
                           StreamObserver<Comunicacao.Reply> responseObserver) {

        BigInteger key = ToBigInteger(request.getKey().getValue());

        Comunicacao.Reply rp = null;

        if(hashtable.containsKey(key)) {
            HashtableValue htValue = hashtable.get(key);

            if(htValue.version == request.getVersion()) {
                rp = CreateReply("SUCCESS", htValue.version, htValue.timestamp, htValue.data);

                Comunicacao.VTripla vTriple = request.getValue();
                htValue.timestamp = vTriple.getTimestamp();
                htValue.data = ToByteArray(vTriple.getData());
                htValue.version = vTriple.getVersion();

                hashtable.put(key,htValue);
            }
            else {
                rp = CreateReply("ERROR_WV", htValue.version, htValue.timestamp, htValue.data);
            }
        }
        else {
            rp = CreateReply("ERROR_NE");
        }

        SendReply(responseObserver, rp);
    }

    private void writeHashtableFile(Hashtable<BigInteger, HashtableValue> hashtable) {
        try {
            dbNosqlRepository.writeHashtableFile(hashtable);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error writing hashtable\nERROR: ", e);
        }
    }

    private Hashtable<BigInteger, HashtableValue> initializeHashtable() {
        try {
            Hashtable<BigInteger, HashtableValue> hashtable = this.dbNosqlRepository.readHashtableFile();
            logger.info("Reading previous Hashtable\nSIZE TABLE: " + hashtable.size());
            return hashtable;
        } catch (Exception e) {
            logger.log(Level.WARNING, "Starting a new Hashtable\nERROR: ", e);
            return new Hashtable<>();
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

    public Comunicacao.Reply CreateReply(String ErrorCode) {//, Comunicacao.VTripla VTripla){
        Comunicacao.Reply.Builder rp = Comunicacao.Reply.newBuilder();
        rp.setError(ErrorCode);
//        rp.setValue(VTripla);
        return rp.build();
    }

    public void SendReply(StreamObserver<Comunicacao.Reply> responseObserver, Comunicacao.Reply Reply) {
        responseObserver.onNext(Reply);
        responseObserver.onCompleted();
    }

//    public void SendReply(StreamObserver<Comunicacao.Reply> responseObserver, String ErrorCode, long Version, long Timestamp, byte[] Data)
//    {
//        SendReply(responseObserver, CreateReply(ErrorCode,Version,Timestamp,Data));
//    }
//
//    public void SendReply(StreamObserver<Comunicacao.Reply> responseObserver, String ErrorCode, Comunicacao.VTripla VTripla)
//    {
//        SendReply(responseObserver, CreateReply(ErrorCode,VTripla));
//    }

    public ByteString ToByteString(BigInteger BigInt)
    {
        return ToByteString(ToByteArray(BigInt));
    }

    public ByteString ToByteString(byte[] ByteArray)
    {
        return ByteString.copyFrom(ByteArray);
    }

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
