package com.jsrdxzw.kubernetes.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author xuzhiwei
 * @date 2022/8/5 10:26
 */
@RestController
public class NameController {
    private static final Logger LOG = LoggerFactory.getLogger(NameController.class);

    private final String hostName = System.getenv("HOSTNAME");

    @GetMapping("/")
    public String ribbonPing() {
        LOG.info("Ribbon ping");
        return hostName;
    }

    /**
     * Endpoint to get a name with a capability to delay a response for some number of
     * milliseconds.
     *
     * @param delayValue Milliseconds for how long the response should be delayed.
     * @return Host name.
     */
    @GetMapping("/name")
    public Mono<String> getName(@RequestParam(value = "delay", defaultValue = "0") int delayValue) {
        LOG.info(String.format("Returning a name '%s' with a delay '%d'", hostName, delayValue));
        delay(delayValue);
        return Mono.just(hostName);
    }

    private void delay(int delayValue) {
        try {
            Thread.sleep(delayValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
