package com.blockchaincomputing.tasktracker.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
@PropertySource("classpath:application.properties")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String DB;

    @Value("${spring.data.mongodb.uri}")
    private String URI;

    @Override
    protected String getDatabaseName() {
        return DB;
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://yosri:yosri2021$@cluster0.mozfi.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }
}
