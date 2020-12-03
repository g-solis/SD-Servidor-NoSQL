package com.ufu.sd.dbnosql;
import com.ufu.sd.dbnosql.controller.*;
import io.grpc.stub.*;

public class DbNosqlService extends CrudKeyValueGrpc.CrudKeyValueImplBase{

//    TODO_TabelaHash Table;
//
//    public DbNosqlService(TODO_TabelaHash Table)
//    {
//        this.Table = Table;
//    }

    @Override
    public void set(Comunicacao.SetRequest request,
                    StreamObserver<Comunicacao.Reply> responseObserver) {

        //Implementar
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
