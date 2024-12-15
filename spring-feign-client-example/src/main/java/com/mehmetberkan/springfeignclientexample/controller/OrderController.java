package com.mehmetberkan.springfeignclientexample.controller;

import com.mehmetberkan.springfeignclientexample.dto.OrderDTO;
import com.mehmetberkan.springfeignclientexample.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestParam Long userId,
                                                @RequestParam Long productId,
                                                @RequestParam Integer quantity) {
        OrderDTO orderDTO = orderService.createOrder(userId, productId, quantity);
        return ResponseEntity.ok(orderDTO);
    }

}
