package com.khang.example.document_agent.configuration;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClientFactory;
import com.mongodb.client.MongoClients;
import dev.langchain4j.store.embedding.mongodb.IndexMapping;
import dev.langchain4j.store.embedding.mongodb.MongoDbEmbeddingStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBAtlasConfiguration {

    private String uri = "";

    private String databaseName = "";

    private String collectionName = "";

    private String indexName = "";

    @Bean
    public MongoClient mongoClientBean(){
        MongoClient mongoClient = MongoClients.create(uri);
        return mongoClient;
    }

    @Bean
    public MongoDbEmbeddingStore embeddingStoreBean(@Autowired MongoClient mongoClient){
        MongoDbEmbeddingStore embeddingStore = MongoDbEmbeddingStore
                .builder()
                .fromClient(mongoClient)
                .databaseName(databaseName)
                .collectionName(collectionName)
                .indexName(indexName)
                .indexMapping(
                        IndexMapping
                                .builder()
                                .dimension(2048)

                                .build())
                .createIndex(true)
                .build();

        return embeddingStore;
    }

}
