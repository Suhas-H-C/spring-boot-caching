package com.prac.order.controller;

import com.prac.order.service.PlaceHolderService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PlaceHolderControllerTest {

    private final PlaceHolderService service = mock(PlaceHolderService.class);
    private final PlaceHolderController controller = new PlaceHolderController(service);

    @Test
    void should_return_users_when_gateway_is_called() {
        when(service.getAllUsers()).thenReturn("[{}]");
        String users = controller.getUsers();
        assertNotNull(users);
        verify(service).getAllUsers();
    }
}