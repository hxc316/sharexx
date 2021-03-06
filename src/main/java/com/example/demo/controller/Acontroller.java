package com.example.demo.controller;

import com.example.demo.dao.OrderRepository;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class Acontroller {
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("/add")
    public Object add() {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId((long) i);
            order.setOrderId((long) i);
            orderRepository.save(order);
        }
        for (int i = 10; i < 20; i++) {
            Order order = new Order();
            order.setUserId((long) i + 1);
            order.setOrderId((long) i);
            orderRepository.save(order);
        }
        return "success";
    }

    @RequestMapping("query")
    private Object queryAll() {
        return orderRepository.findAll();
    }
}
