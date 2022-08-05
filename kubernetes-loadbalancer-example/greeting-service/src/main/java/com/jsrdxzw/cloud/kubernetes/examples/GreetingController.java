package com.jsrdxzw.cloud.kubernetes.examples;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author xuzhiwei
 * @date 2022/8/5 14:22
 */
@RestController
public class GreetingController {
    private final NameService nameService;

    private final DiscoveryClient discoveryClient;

    public GreetingController(NameService nameService, DiscoveryClient discoveryClient) {
        this.nameService = nameService;
        this.discoveryClient = discoveryClient;
    }

    /**
     * Endpoint to get a greeting. This endpoint uses a name server to get a name for the
     * greeting.
     * <p>
     * Request to the name service is guarded with a circuit breaker. Therefore, if a name
     * service is not available or is too slow to response fallback name is used.
     * <p>
     * Delay parameter can be used to make name service response slower.
     *
     * @param delay Milliseconds for how long the response from name service should be
     *              delayed.
     * @return Greeting string.
     */
    @GetMapping("/greeting")
    public Mono<String> getGreeting(@RequestParam(value = "delay", defaultValue = "0") int delay) {
        return nameService.getName(delay).map(name -> String.format("Hello from %s!", name));
    }

    @RequestMapping("/services")
    public List<String> services() {
        return this.discoveryClient.getServices();
    }
}
