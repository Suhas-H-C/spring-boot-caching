package com.prac.order.controller;

import com.prac.order.entity.Order;
import com.prac.order.service.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v2/orders")
@AllArgsConstructor
public class OrderServiceController {

    private final OrderServiceImpl service;

    @GetMapping(value = "/{orderId}")
    public Order saveOrder(@PathVariable(name = "orderId") Integer orderId) {
        return service.getOrderById(orderId);
    }

    @GetMapping(value = "/all")
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @PostMapping(value = "/save")
    public Order saveOrder(@RequestBody Order order) {
        return service.saveOrder(order);
    }
}
