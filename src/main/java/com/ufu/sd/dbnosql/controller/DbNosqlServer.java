package com.ufu.sd.dbnosql.controller;

import com.ufu.sd.dbnosql.DbNosqlService;
import com.ufu.sd.dbnosql.model.HashtableValue;
import com.ufu.sd.dbnosql.repository.DbNosqlRepository;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbNosqlServer{
    private static final Logger logger = Logger.getLogger(DbNosqlServer.class.getName());

    private final int port;
    private final Server server;

    public DbNosqlServer(int port, String dirHashtable) {
        this.port = port;
        server = ServerBuilder.forPort(port).addService(new DbNosqlService(dirHashtable)).build();
    }

    public void start() throws IOException {
        server.start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    DbNosqlServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) {
        try {
            DbNosqlServer server = new DbNosqlServer(8980, "hash");
            server.start();
            server.blockUntilShutdown();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Start server failed: ", e);
        }
    }

}
