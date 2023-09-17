package com.prac.order.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${json.placeholder.name}", url = "${json.placeholder.url}")
public interface PlaceHolderGateway {

    @GetMapping(value = "/users")
    String getAllUsers();
}
