package com.ufu.sd.dbnosql.repository;
import com.ufu.sd.dbnosql.model.HashtableValue;

import java.io.*;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;

public class DbNosqlRepository {

    private String dirfile;

    public DbNosqlRepository(String dirfile) {
        this.dirfile = dirfile;
    }

    public void writeHashtableFile(ConcurrentHashMap<BigInteger, HashtableValue> hashtable) throws IOException {
        FileOutputStream fos = new FileOutputStream(dirfile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(hashtable);
        oos.close();
    }

    public ConcurrentHashMap<BigInteger, HashtableValue> readHashtableFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(dirfile);
        ObjectInputStream ois = new ObjectInputStream(fis);

        return (ConcurrentHashMap<BigInteger, HashtableValue>) ois.readObject();
    }

}
