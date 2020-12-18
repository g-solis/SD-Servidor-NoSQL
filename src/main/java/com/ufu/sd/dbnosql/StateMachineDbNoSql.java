package com.ufu.sd.dbnosql;

import com.google.protobuf.ByteString;
import com.ufu.sd.dbnosql.controller.Comunicacao;
import com.ufu.sd.dbnosql.model.HashtableValue;
import org.apache.ratis.proto.RaftProtos;
import org.apache.ratis.protocol.Message;
import org.apache.ratis.statemachine.TransactionContext;
import org.apache.ratis.statemachine.impl.BaseStateMachine;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;


public class StateMachineDbNoSql extends BaseStateMachine
{
    private final ConcurrentHashMap<BigInteger, HashtableValue> hashmap = new ConcurrentHashMap<>();

    @Override
    public CompletableFuture<Message> query(Message request) {
        final String[] opKey = request.getContent().toString(Charset.defaultCharset()).split(":");
        final String result = opKey[0]+ ":"+ hashmap.get(opKey[1]);

        LOG.debug("{}: {} = {}", opKey[0], opKey[1], result);
        return CompletableFuture.completedFuture(Message.valueOf(result));
    }


    @Override
    public CompletableFuture<Message> applyTransaction(TransactionContext trx) {

//        TransactionContext ctx = null;
//        String str = ctx.getClientRequest().getMessage().getContent().toString();
//
//        String[] array =  str.split(":");
//
//        Comunicacao.SetRequest.parseFrom(ByteString.copyFromUtf8(array[1]));




        final RaftProtos.LogEntryProto entry = trx.getLogEntry();
        final String[] opKeyValue = entry.getStateMachineLogEntry().getLogData().toString(Charset.defaultCharset()).split(":");

        final CompletableFuture<Message> f = null;

//        final String result = opKeyValue[0]+ ":"+ hashmap.put();
//
//        final CompletableFuture<Message> f = CompletableFuture.completedFuture(Message.valueOf(result));
//
//        final RaftProtos.RaftPeerRole role = trx.getServerRole();
//        LOG.info("{}:{} {} {}={}", role, getId(), opKeyValue[0], opKeyValue[1], opKeyValue[2]);
//
//        if (LOG.isTraceEnabled()) {
//            LOG.trace("{}: key/values={}", getId(), hashmap);
//        }
        return f;
    }
}