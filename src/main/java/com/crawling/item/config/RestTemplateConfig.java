package com.crawling.item.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

        HttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(200)
                .setMaxConnTotal(10)
                .build();
        factory.setReadTimeout(Duration.ofSeconds(10L).toMillisPart());
        factory.setConnectTimeout(Duration.ofSeconds(10L).toMillisPart());
        factory.setHttpClient(httpClient);

        return new RestTemplate(factory);
    }

}
