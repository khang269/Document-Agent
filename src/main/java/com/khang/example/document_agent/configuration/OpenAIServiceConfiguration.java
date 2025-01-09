package com.khang.example.document_agent.configuration;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIServiceConfiguration {

    private String chatBaseUrl ="";
    private String embeddingBaseUrl = "";

    private String apiKey = "";

    @Bean
    public EmbeddingModel embeddingModelBean(){
        OpenAiEmbeddingModel embeddingModel = OpenAiEmbeddingModel
                .builder()
                .apiKey(apiKey)
                .baseUrl(embeddingBaseUrl)
                .dimensions(2048)
                .build();

        return embeddingModel;
    }

    @Bean
    public ChatLanguageModel chatLanguageModelBean(){
        ChatLanguageModel chatLanguageModel =
                OpenAiChatModel
                        .builder()
                        .baseUrl(chatBaseUrl)
                        .apiKey(apiKey)
                        .build();

        return chatLanguageModel;
    }

}
