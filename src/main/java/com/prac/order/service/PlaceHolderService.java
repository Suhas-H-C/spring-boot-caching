package com.prac.order.service;

import com.prac.order.gateway.PlaceHolderGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PlaceHolderService {

    private final PlaceHolderGateway gateway;

    public String getAllUsers() {
        return gateway.getAllUsers();
    }
}
