package com.ufu.sd.dbnosql.controller;

public class DbNosqlService extends CrudKeyValueGrpc.CrudKeyValueImplBase{
    @Override
    public void get(com.ufu.sd.dbnosql.controller.Comunicacao.GetRequest request,
                    io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {
        //Implementar


    }

    @Override
    public void del(com.ufu.sd.dbnosql.controller.Comunicacao.DelRequest request,
                    io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {

        //Implementar

    }

    @Override
    public void delVers(com.ufu.sd.dbnosql.controller.Comunicacao.DelRequestVers request,
                        io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {

        //Implementar

    }

    @Override
    public void testAndSet(com.ufu.sd.dbnosql.controller.Comunicacao.TestAndSetRequest request,
                           io.grpc.stub.StreamObserver<com.ufu.sd.dbnosql.controller.Comunicacao.Reply> responseObserver) {

        //Implementar

    }
}