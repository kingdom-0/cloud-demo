package com.jx.order.service;

import com.jx.order.entity.Order;
import com.jx.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Edison Wang
 * @version 1.0
 * @description TODO
 * @date 2023/5/11 11:58
 */

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order queryOrderById(long orderId){
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if(optionalOrder.isPresent()){
            return optionalOrder.get();
        }
        return null;
    }
}
