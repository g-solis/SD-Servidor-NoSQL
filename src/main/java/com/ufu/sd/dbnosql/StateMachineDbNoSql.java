package com.ufu.sd.dbnosql;

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

public class StateMachineDbNoSql extends BaseStateMachine {
    private final Map<BigInteger, HashtableValue> hashtable = new ConcurrentHashMap<>();

    @Override
    public CompletableFuture<Message> query(Message request) {
        String opKeyValue = request.getContent().toString(Charset.defaultCharset());
        BigInteger key = new BigInteger(opKeyValue.getBytes());
        String result;

        HashtableValue htValue = hashtable.get(key);

        if(htValue != null) {
            result = "SUCCESS:" + htValue.version + ":" + htValue.timestamp + ":" + new String(htValue.data);
        }
        else {
            result = "ERROR";
        }

        return CompletableFuture.completedFuture(Message.valueOf(result));
    }


    @Override
    public CompletableFuture<Message> applyTransaction(TransactionContext trx) {
        final RaftProtos.LogEntryProto entry = trx.getLogEntry();
        final String[] opKeyValue = entry.getStateMachineLogEntry().getLogData().toString(Charset.defaultCharset()).split(":");
        String result = "";

        switch (opKeyValue[0]) {
            case "set":
                result = setOperation(opKeyValue);
                break;
            case "del":
                result = delOperation(opKeyValue);
                break;
            case "delVers":
                result = delVersOperation(opKeyValue);
                break;
            case "testAndSet":
                result = testAndSetOperation(opKeyValue);
                break;
        }

        return CompletableFuture.completedFuture(Message.valueOf(result));
    }

    private String setOperation(String[] opKeyValue) {
        BigInteger key = new BigInteger(opKeyValue[1].getBytes());
        long timestamp = Long.parseLong(opKeyValue[2]);
        byte[] data = opKeyValue[3].getBytes();

        HashtableValue htValue = hashtable.putIfAbsent(key, new HashtableValue(1,timestamp,data));

        if(htValue == null) {
            return "SUCCESS";
        }

        return "ERROR:" + htValue.version + ":" + htValue.timestamp + ":" + new String(htValue.data);
    }

    private String delOperation(String[] opKeyValue) {
        BigInteger key = new BigInteger(opKeyValue[1].getBytes());

        HashtableValue htValue = hashtable.remove(key);

        if(htValue != null) {
            return "SUCCESS:" + htValue.version + ":" + htValue.timestamp + ":" + new String(htValue.data);
        }

        return "ERROR";
    }

    private String delVersOperation(String[] opKeyValue) {
        BigInteger key = new BigInteger(opKeyValue[1].getBytes());
        long version = Long.parseLong(opKeyValue[2]);

        HashtableValue htValue;

        do {
            htValue = hashtable.get(key);
            if (htValue == null) {
                return "ERROR_NE";
            }
            if (htValue.version != version) {
                return "ERROR_WV:" + htValue.version + ":" + htValue.timestamp + ":" + new String(htValue.data);
            }
        } while (!hashtable.remove(key, htValue));

        return "SUCCESS:" + htValue.version + ":" + htValue.timestamp + ":" + new String(htValue.data);
    }

    private String testAndSetOperation(String[] opKeyValue) {
        BigInteger key = new BigInteger(opKeyValue[1].getBytes());
        long version = Long.parseLong(opKeyValue[2]);
        long timestamp = Long.parseLong(opKeyValue[3]);
        byte[] data = opKeyValue[4].getBytes();
        long oldVersion = Long.parseLong(opKeyValue[5]);

        HashtableValue htValue;

        HashtableValue newHtValue = new HashtableValue(version, timestamp, data);

        do {
            htValue = hashtable.get(key);
            if (htValue == null) {
                return "ERROR_NE";
            }
            if (htValue.version != oldVersion) {
                return "ERROR_WV:" + htValue.version + ":" + htValue.timestamp + ":" + new String(htValue.data);
            }
        } while (!hashtable.replace(key, htValue, newHtValue));

        return "SUCCESS:" + htValue.version + ":" + htValue.timestamp + ":" + new String(htValue.data);
    }
}