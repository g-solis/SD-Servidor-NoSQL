package com.ufu.sd.dbnosql;
import com.google.protobuf.ByteString;
import com.ufu.sd.dbnosql.controller.*;
import com.ufu.sd.dbnosql.model.HashtableValue;
import com.ufu.sd.dbnosql.repository.DbNosqlRepository;
import io.grpc.stub.*;

import java.math.BigInteger;
import java.util.Hashtable;

public class DbNosqlService extends CrudKeyValueGrpc.CrudKeyValueImplBase{

    private Hashtable<BigInteger, HashtableValue> hashtable;

    public DbNosqlService() {
        this.hashtable = new Hashtable<>();
//        this.hashtable = DbNosqlRepository.readHashtableFile();
    }

    @Override
    public void set(Comunicacao.SetRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {

        BigInteger key = ToBigInteger(request.getKey().getValue());

        Comunicacao.Reply rp = null;

        if(hashtable.containsKey(key))
        {
            HashtableValue htValue =  hashtable.get(key);

            rp = CreateReply("ERROR", htValue.version,htValue.timestamp,htValue.data);
        }
        else
        {
            long timestamp = request.getTimestamp();
            byte[] data = request.getData().toByteArray();

            hashtable.put(key, new HashtableValue(1,timestamp,data));

            rp = CreateReply("SUCCESS",null);
        }

        SendReply(responseObserver, rp);
    }

    @Override
    public void get(Comunicacao.GetRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {

        BigInteger key = ToBigInteger(request.getKey().getValue());

        Comunicacao.Reply rp = null;

        if(hashtable.containsKey(key))
        {
            HashtableValue htValue =  hashtable.get(key);

            rp = CreateReply("SUCCESS", htValue.version,htValue.timestamp,htValue.data);
        }
        else
        {
            rp = CreateReply("ERROR",null);
        }

        SendReply(responseObserver, rp);
    }

    @Override
    public void del(Comunicacao.DelRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {

        BigInteger key = ToBigInteger(request.getKey().getValue());

        Comunicacao.Reply rp = null;

        if(hashtable.containsKey(key))
        {
            HashtableValue htValue =  hashtable.remove(key);

            rp = CreateReply("SUCCESS", htValue.version,htValue.timestamp,htValue.data);
        }
        else
        {
            rp = CreateReply("ERROR",null);
        }

        SendReply(responseObserver, rp);
    }

    @Override
    public void delVers(Comunicacao.DelRequestVers request,
                        StreamObserver<Comunicacao.Reply> responseObserver) {

        BigInteger key = ToBigInteger(request.getKey().getValue());

        Comunicacao.Reply rp = null;

        if(hashtable.containsKey(key))
        {
            HashtableValue htValue = hashtable.get(key);

            if(htValue.version == request.getVersion())
            {
                hashtable.remove(key);

                rp = CreateReply("SUCCESS", htValue.version,htValue.timestamp,htValue.data);
            }
            else
            {
                rp = CreateReply("ERROR_WV", htValue.version,htValue.timestamp,htValue.data);
            }
        }
        else
        {
            rp = CreateReply("ERROR_NE",null);
        }

        SendReply(responseObserver, rp);

    }

    @Override
    public void testAndSet(Comunicacao.TestAndSetRequest request,
                           StreamObserver<Comunicacao.Reply> responseObserver) {

        BigInteger key = ToBigInteger(request.getKey().getValue());

        Comunicacao.Reply rp = null;

        if(hashtable.containsKey(key))
        {
            HashtableValue htValue = hashtable.get(key);

            if(htValue.version == request.getVersion())
            {
                rp = CreateReply("SUCCESS", htValue.version,htValue.timestamp,htValue.data);

                htValue.timestamp = request.getValue().getTimestamp();
                htValue.data = ToByteArray(request.getValue().getData());
                htValue.version += 1;

                hashtable.put(key,htValue);
            }
            else
            {
                rp = CreateReply("ERROR_WV", htValue.version,htValue.timestamp,htValue.data);
            }
        }
        else
        {
            rp = CreateReply("ERROR_NE",null);
        }

        SendReply(responseObserver, rp);

    }

    public Comunicacao.VTripla CreateVTripla(long Version, long Timestamp, byte[] Data)
    {
        Comunicacao.VTripla.Builder vt = Comunicacao.VTripla.newBuilder();
        vt.setVersion(Version);
        vt.setTimestamp(Timestamp);
        vt.setData(ToByteString(Data));
        return vt.build();
    }

    public Comunicacao.Reply CreateReply(String ErrorCode, long Version, long Timestamp, byte[] Data)
    {
        Comunicacao.Reply.Builder rp = Comunicacao.Reply.newBuilder();
        rp.setError(ErrorCode);
        rp.setValue(CreateVTripla(Version,Timestamp,Data));
        return rp.build();
    }

    public Comunicacao.Reply CreateReply(String ErrorCode, Comunicacao.VTripla VTripla)
    {
        Comunicacao.Reply.Builder rp = Comunicacao.Reply.newBuilder();
        rp.setError(ErrorCode);
        rp.setValue(VTripla);
        return rp.build();
    }


    public void SendReply(StreamObserver<Comunicacao.Reply> responseObserver, Comunicacao.Reply Reply)
    {
        responseObserver.onNext(Reply);
        responseObserver.onCompleted();
    }

    public void SendReply(StreamObserver<Comunicacao.Reply> responseObserver, String ErrorCode, long Version, long Timestamp, byte[] Data)
    {
        SendReply(responseObserver, CreateReply(ErrorCode,Version,Timestamp,Data));
    }

    public void SendReply(StreamObserver<Comunicacao.Reply> responseObserver, String ErrorCode, Comunicacao.VTripla VTripla)
    {
        SendReply(responseObserver, CreateReply(ErrorCode,VTripla));
    }

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
