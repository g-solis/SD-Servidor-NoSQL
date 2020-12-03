package com.ufu.sd.dbnosql;
import com.ufu.sd.dbnosql.controller.*;
import com.ufu.sd.dbnosql.model.HashtableValue;
import io.grpc.stub.*;

import java.math.BigInteger;
import java.util.Hashtable;

public class DbNosqlService extends CrudKeyValueGrpc.CrudKeyValueImplBase{

    private Hashtable<BigInteger, HashtableValue> hashtable;

    public DbNosqlService() {
        this.hashtable = new Hashtable<>();
    }

    @Override
    public void set(Comunicacao.SetRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {
        BigInteger key = new BigInteger(request.getKey().getValue().toByteArray());
        long timestamp = request.getTimestamp();
        byte[] data = request.getData().toByteArray();
        long version = 1;

        Comunicacao.VTripla vt = Comunicacao.VTripla.newBuilder().setVersion(version).setTimestamp(timestamp).setData(request.getData()).build();
        Comunicacao.Reply rp = Comunicacao.Reply.newBuilder().setError("ERROR").setValue(vt).build();
        responseObserver.onNext(rp);
        responseObserver.onCompleted();
    }

    @Override
    public void get(Comunicacao.GetRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {
        //Implementar


    }

    @Override
    public void del(Comunicacao.DelRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {

        //Implementar

    }

    @Override
    public void delVers(Comunicacao.DelRequestVers request,
                        StreamObserver<Comunicacao.Reply> responseObserver) {

        //Implementar

    }

    @Override
    public void testAndSet(Comunicacao.TestAndSetRequest request,
                           StreamObserver<Comunicacao.Reply> responseObserver) {

        //Implementar

    }
}
