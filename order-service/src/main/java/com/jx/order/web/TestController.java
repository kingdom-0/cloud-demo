package com.jx.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Edison Wang
 * @version 1.0
 * @description TODO
 * @date 2023/5/11 22:16
 */

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RestTemplate urlCleanedRestTemplate;

    @Autowired
    private RestTemplate restTemplate;

    //@Autowired
    //private EchoClient echoClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String SERVICE_PROVIDER_ADDRESS = "http://userservice";

    @GetMapping("/echo-rest/{str}")
    public String rest(@PathVariable String str) {
        return urlCleanedRestTemplate
                .getForObject(SERVICE_PROVIDER_ADDRESS + "/echo/" + str,
                        String.class);
    }

    @GetMapping("/index")
    public String index() {
        return restTemplate.getForObject(SERVICE_PROVIDER_ADDRESS, String.class);
    }

    @GetMapping("/test")
    public String test() {
        return restTemplate
                .getForObject(SERVICE_PROVIDER_ADDRESS + "/test", String.class);
    }

    @GetMapping("/sleep")
    public String sleep() {
        return restTemplate
                .getForObject(SERVICE_PROVIDER_ADDRESS + "/sleep", String.class);
    }

    @GetMapping("/notFound-feign")
    public String notFound() {
        return "notFound-feign";
        //return echoClient.notFound();
    }

    @GetMapping("/divide-feign")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        return "/divide-feign";
        //return echoClient.divide(a, b);
    }

    @GetMapping("/divide-feign2")
    public String divide(@RequestParam Integer a) {
        return "empty";
        //return echoClient.divide(a);
    }

    @GetMapping("/echo-feign/{str}")
    public String feign(@PathVariable String str) {
        return "empty";
        //return echoClient.echo(str);
    }

    @GetMapping("/services/{service}")
    public Object client(@PathVariable String service) {
        return discoveryClient.getInstances(service);
    }

    @GetMapping("/services")
    public Object services() {
        return discoveryClient.getServices();
    }

}
