package com.fruit.app.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoDBConfiguration extends AbstractMongoConfiguration {

    @Value("${database.name:item}")
    private String database;

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private int port;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(host, port);
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }

}
