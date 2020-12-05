package com.ufu.sd.dbnosql.repository;
import com.ufu.sd.dbnosql.model.HashtableValue;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class DbNosqlRepository {

    private String dirfile; //"/tmp/hash"

    public DbNosqlRepository(String dirfile) {
        this.dirfile = dirfile;
    }

    public void writeHashtableFile(Hashtable<BigInteger, HashtableValue> hashtable) throws IOException {
        FileOutputStream fos = new FileOutputStream(dirfile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(hashtable);
        oos.close();
    }

    public Hashtable<BigInteger, HashtableValue> readHashtableFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(dirfile);
        ObjectInputStream ois = new ObjectInputStream(fis);

        return (Hashtable<BigInteger, HashtableValue>) ois.readObject();
    }

}
