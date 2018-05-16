package com.facishare.common.unittest.mongo.impl;

import com.mongodb.MongoClient;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

import java.io.IOException;

/**
 * Created by fengyuqian on 16/11/23.
 */

public class MongoFactory {

  private MongodExecutable mongodExe;
  private MongoClient mongo;

  public MongoClient mongo() throws IOException {
    int port = Network.getFreeServerPort();
    // Storage replication = new Storage("/Users/fengyuqian/custom/databaseDir",null,0);
    MongodStarter runtime = MongodStarter.getDefaultInstance();
    IMongodConfig MongodConfig = new MongodConfigBuilder()
        .version(Version.Main.PRODUCTION)
        //        .replication(replication)
        .net(new Net(port, Network.localhostIsIPv6()))
        .build();
    mongodExe = runtime.prepare(MongodConfig);
    mongodExe.start();
    mongo = new MongoClient("localhost", port);
    return mongo;
  }
}
