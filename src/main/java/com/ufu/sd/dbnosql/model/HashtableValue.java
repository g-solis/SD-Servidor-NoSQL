package com.ufu.sd.dbnosql.model;

import java.util.Hashtable;

public class HashtableValue {
    private long version;
    private long timestamp;
    private byte[] data;

    public HashtableValue(long version, long timestamp, byte[] data) {
        this.version = version;
        this.timestamp = timestamp;
        this.data = data;
    }
}
