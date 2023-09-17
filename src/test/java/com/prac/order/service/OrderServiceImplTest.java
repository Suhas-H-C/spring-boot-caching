package com.prac.order.service;

import com.prac.order.entity.Order;
import com.prac.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    private final OrderRepository repository = mock(OrderRepository.class);
    private final OrderServiceImpl service = new OrderServiceImpl(repository);

    @Test
    void should_save_and_return_when_repository_is_called_for_order() {
        Order order = Order.builder().orderId(12).orderNumber("Test Sample 1").orderStatus(true).build();
        when(repository.save(order)).thenReturn(order);
        Order actualResponse = service.saveOrder(order);
        assertEquals(order.getOrderId(), actualResponse.getOrderId());
        verify(repository).save(order);
        verify(repository, never()).findAll();
        verify(repository, never()).findById(order.getOrderId());
    }

    @Test
    void should_return_order_when_proper_id_is_passed() {
        Order order = Order.builder().orderId(11).orderNumber("Test Sample 2").orderStatus(false).build();
        when(repository.findById(order.getOrderId())).thenReturn(Optional.ofNullable(order));
        Order actualResponse = service.getOrderById(order.getOrderId());
        assertFalse(actualResponse.isOrderStatus());
        verify(repository, never()).findAll();
        verify(repository).findById(order.getOrderId());
        verify(repository, never()).save(order);
    }

    @Test
    void should_return_all_entries_when_repository_is_called() {
        Order order = Order.builder().orderId(10).orderNumber("Test Sample 3").orderStatus(false).build();
        when(repository.findAll()).thenReturn(List.of(order));
        List<Order> actualResponse = service.getAllOrders();
        assertFalse(actualResponse.isEmpty());
        verify(repository).findAll();
        verify(repository, never()).findById(order.getOrderId());
        verify(repository, never()).save(order);
    }
}