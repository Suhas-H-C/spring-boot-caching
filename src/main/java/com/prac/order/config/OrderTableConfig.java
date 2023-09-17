package com.prac.order.config;

import com.prac.order.entity.Order;
import com.prac.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
@AllArgsConstructor
public class OrderTableConfig implements CommandLineRunner {

    private final OrderRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(List.of(
                Order.builder().orderId(1).orderNumber("Sample 1").orderStatus(true).build(),
                Order.builder().orderId(2).orderNumber("Sample 2").orderStatus(false).build()));
        log.info("Saved items");
    }
}
