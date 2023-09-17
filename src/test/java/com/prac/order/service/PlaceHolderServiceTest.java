package com.prac.order.service;

import com.prac.order.gateway.PlaceHolderGateway;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlaceHolderServiceTest {

    private final PlaceHolderGateway gateway = mock(PlaceHolderGateway.class);
    private PlaceHolderService service = new PlaceHolderService(gateway);

    @Test
    void should_return_valid_response_when_feign_gateway_is_invoked() {
        when(gateway.getAllUsers()).thenReturn("[{}]");
        String actualResponse = service.getAllUsers();
        assertNotNull(actualResponse);
        verify(gateway).getAllUsers();
    }
}