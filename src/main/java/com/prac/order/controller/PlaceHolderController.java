package com.prac.order.controller;

import com.prac.order.service.PlaceHolderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v2/json")
@AllArgsConstructor
public class PlaceHolderController {

    private final PlaceHolderService service;

    @GetMapping("/users")
    public String getUsers() {
        return service.getAllUsers();
    }
}
