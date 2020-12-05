package com.ufu.sd.dbnosql.model;

import java.io.Serializable;

public class HashtableValue implements Serializable {
    public long version;
    public long timestamp;
    public byte[] data;

    public HashtableValue(long version, long timestamp, byte[] data) {
        this.version = version;
        this.timestamp = timestamp;
        this.data = data;
    }
}
