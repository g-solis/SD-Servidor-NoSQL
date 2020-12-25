package com.ufu.sd.dbnosql.controller;

import com.ufu.sd.dbnosql.DbNosqlService;
import com.ufu.sd.dbnosql.StateMachineDbNoSql;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.ratis.client.RaftClient;
import org.apache.ratis.conf.Parameters;
import org.apache.ratis.grpc.GrpcFactory;
import org.apache.ratis.protocol.*;
import org.springframework.boot.SpringApplication;

import org.apache.ratis.conf.RaftProperties;
import org.apache.ratis.grpc.GrpcConfigKeys;
import org.apache.ratis.server.RaftServer;
import org.apache.ratis.server.RaftServerConfigKeys;
import org.apache.ratis.thirdparty.com.google.protobuf.ByteString;
import org.apache.ratis.util.LifeCycle;

import org.apache.ratis.statemachine.TransactionContext;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DbNosqlServer{
    private static final Logger logger = Logger.getLogger(DbNosqlServer.class.getName());

    private final int port;
    private final Server server;
    public static DbNosqlService ServiceInstance;

    private Map<String, InetSocketAddress> id2addr = new HashMap<>();

    public DbNosqlServer(String id) {

        ServiceInstance = new DbNosqlService();

        id2addr.put("p1", new InetSocketAddress("127.0.0.1", 3000));
        id2addr.put("p2", new InetSocketAddress("127.0.0.1", 3500));
        id2addr.put("p3", new InetSocketAddress("127.0.0.1", 4000));

        if(!id2addr.containsKey(id))
        {
            System.out.println("Identificador " + id + " é inválido.");
            System.exit(1);
        }

        port = id2addr.get(id).getPort()+1;
        server = ServerBuilder.forPort(port).addService(ServiceInstance).build();
    }

    public void startGrpc() throws IOException {

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

    public void startRaft(String[] args) throws IOException, InterruptedException
    {
        String raftGroupId = "raft_group___UFU";

        List<RaftPeer> addresses = id2addr.entrySet()
                .stream()
                .map(e -> new RaftPeer(RaftPeerId.valueOf(e.getKey()), e.getValue()))
                .collect(Collectors.toList());

        RaftPeerId myId = RaftPeerId.valueOf(args[0]);

        RaftProperties properties = new RaftProperties();
        properties.setInt(GrpcConfigKeys.OutputStream.RETRY_TIMES_KEY, Integer.MAX_VALUE);

        GrpcConfigKeys.Server.setPort(properties, id2addr.get(args[0]).getPort());
        RaftServerConfigKeys.setStorageDir(properties, Collections.singletonList(new File("/tmp/" + myId)));

        final RaftGroup raftGroup = RaftGroup.valueOf(RaftGroupId.valueOf(ByteString.copyFromUtf8(raftGroupId)), addresses);
        RaftServer raftServer = RaftServer.newBuilder()
                .setServerId(myId)
                .setStateMachine(new StateMachineDbNoSql()).setProperties(properties)
                .setGroup(raftGroup)
                .build();

        RaftProperties tempProp = new RaftProperties();
        RaftClient raftClient = RaftClient.newBuilder()
                .setProperties(tempProp)
                .setRaftGroup(raftGroup)
                .setClientRpc(new GrpcFactory(new Parameters())
                .newRaftClientRpc(ClientId.randomId(), tempProp))
                .build();

        ServiceInstance.raftClient = raftClient;

        raftServer.start();

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
            DbNosqlServer server = new DbNosqlServer(args[0]);
            server.startGrpc();
            server.startRaft(args);
            server.blockUntilShutdown();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Start server failed: ", e);
        }
    }
}
