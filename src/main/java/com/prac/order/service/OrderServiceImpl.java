package com.prac.order.service;

import com.prac.order.entity.Order;
import com.prac.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl {

    private final OrderRepository repository;

    @CachePut(value = "adding", key = "#order.orderId")
    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    @Cacheable(value = "getById", key = "#id")
    public Order getOrderById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Cacheable(value = "orderCache")
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @CacheEvict(value = {"orderCache","getById"}, allEntries = true)
    @Scheduled(cron = "0 * * ? * *") // This cron expression triggers the method every minute
    public void evictCacheAtEveryMinute() {
        // This method will remove all entries from the "orderCache" cache every minute.
    }
}
