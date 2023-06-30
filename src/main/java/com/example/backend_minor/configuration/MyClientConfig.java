package com.example.backend_minor.configuration;

import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchClients;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.lang.NonNullApi;

import javax.net.ssl.SSLContext;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.backend_minor")
@ComponentScan(basePackages = "com.example.backend_minor")
public class MyClientConfig extends ElasticsearchConfiguration {

    @Override
    public  ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200").
                withClientConfigurer(ElasticsearchClients.ElasticsearchRestClientConfigurationCallback.
                        from(restClientBuilder -> {return restClientBuilder;}))
                .build();
    }
}
