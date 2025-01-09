package com.khang.example.document_agent.configuration;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIServiceConfiguration {

    @Value("${openai.api.llm.model}")
    private String chatModelName ="";

    @Value("${openai.api.llm.url}")
    private String chatBaseUrl ="";

    @Value("${openai.api.embedding.model}")
    private String embeddingModelName = "";

    @Value("${openai.api.embedding.url}")
    private String embeddingBaseUrl = "";

    @Value("${openai.api.key}")
    private String apiKey = "";

    @Bean
    public EmbeddingModel embeddingModelBean(){
        return OpenAiEmbeddingModel
                .builder()
                .apiKey(apiKey)
                .modelName(embeddingModelName)
                .baseUrl(embeddingBaseUrl)
                .dimensions(2048)
                .build();

    }

    @Bean
    public ChatLanguageModel chatLanguageModelBean(){
        ChatLanguageModel chatLanguageModel =
                OpenAiChatModel
                        .builder()
                        .baseUrl(chatBaseUrl)
                        .modelName(chatModelName)
                        .apiKey(apiKey)
                        .build();

        return chatLanguageModel;
    }

}
