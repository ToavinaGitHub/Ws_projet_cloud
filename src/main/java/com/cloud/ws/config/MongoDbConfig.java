package com.cloud.ws.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;


public class MongoDbConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "projet_cloud";
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://mongo:2f6aCHBGGG16f3c6gbEgCchC-cE1FGcA@viaduct.proxy.rlwy.net:55905/projet_cloud");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("com.cloud.ws.Model");
    }
}