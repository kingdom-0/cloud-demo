package com.jx.order.web;

import com.jx.order.pojo.Order;
import com.jx.order.pojo.User;
import com.jx.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Edison Wang
 * @version 1.0
 * @description TODO
 * @date 2023/5/11 11:23
 */

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/data")
    public String getMessage(){
        return "test message from order service.";
    }

    @GetMapping("/{orderId}")
    public Order queryOrderById(@PathVariable("orderId") long orderId){
        Order order = orderService.queryOrderById(orderId);
        String url = "http://userservice/user/"+order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }
}
