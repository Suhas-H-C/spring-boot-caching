package com.prac.order.controller;

import com.prac.order.entity.Order;
import com.prac.order.service.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceControllerTest {

    private final OrderServiceImpl service = mock(OrderServiceImpl.class);
    private final OrderServiceController controller = new OrderServiceController(service);

    @Test
    void should_return_valid_response_when_accurate_id_is_passed() {
        when(service.getOrderById(12)).thenReturn(Order.builder().build());
        Order actualResponse = controller.saveOrder(12);
        assertNull(actualResponse.getOrderNumber());
        verify(service).getOrderById(12);
        verify(service, never()).saveOrder(Order.builder().build());
        verify(service, never()).getAllOrders();
    }

    @Test
    void should_return_all_records_when_repo_is_invoked() {
        when(service.getAllOrders()).thenReturn(List.of());
        List<Order> actualResponse = controller.getAllOrders();
        assertTrue(actualResponse.isEmpty());
        verify(service, never()).getOrderById(12);
        verify(service, never()).saveOrder(Order.builder().build());
        verify(service).getAllOrders();
    }

    @Test
    void should_call_repo_and_save_record_when_object_is_passed() {
        Order order = Order.builder().build();
        when(service.saveOrder(order)).thenReturn(order);
        Order actualResponse = controller.saveOrder(order);
        assertNull(actualResponse.getOrderNumber());
        verify(service, never()).getOrderById(12);
        verify(service).saveOrder(order);
        verify(service, never()).getAllOrders();
    }
}