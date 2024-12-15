package com.mehmetberkan.springfeignclientexample.service;

import com.mehmetberkan.springfeignclientexample.dto.OrderDTO;
import com.mehmetberkan.springfeignclientexample.dto.ProductDTO;
import com.mehmetberkan.springfeignclientexample.dto.UserDTO;
import com.mehmetberkan.springfeignclientexample.feign.ProductClient;
import com.mehmetberkan.springfeignclientexample.feign.UserClient;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final UserClient userClient;
    private final ProductClient productClient;

    public OrderService(UserClient userClient, ProductClient productClient) {
        this.userClient = userClient;
        this.productClient = productClient;
    }

    public OrderDTO createOrder(Long userId, Long productId, Integer quantity) {

        UserDTO userDTO = userClient.getUserById(userId);
        if (userDTO == null) {
            throw new RuntimeException("User not found!");
        }

        ProductDTO productDTO = productClient.getProductId(productId);
        if (productDTO == null) {
            throw new RuntimeException("Product not found!");
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(userId);
        orderDTO.setProductId(productId);
        orderDTO.setTotalPrice(productDTO.getPrice() * quantity);

        return orderDTO;
    }
}
