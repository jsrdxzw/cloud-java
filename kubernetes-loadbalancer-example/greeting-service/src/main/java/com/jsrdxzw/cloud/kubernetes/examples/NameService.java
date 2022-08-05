package com.jsrdxzw.cloud.kubernetes.examples;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author xuzhiwei
 * @date 2022/8/5 14:20
 */
@Service
public class NameService {
    private final WebClient webClient;

    public NameService(WebClient.Builder webClientBuilder) {
        webClient = webClientBuilder.build();
    }

    public Mono<String> getName(int delay) {
        return webClient.get().uri(String.format("http://name-service/name?delay=%d", delay)).retrieve()
                .bodyToMono(String.class);
    }
}
