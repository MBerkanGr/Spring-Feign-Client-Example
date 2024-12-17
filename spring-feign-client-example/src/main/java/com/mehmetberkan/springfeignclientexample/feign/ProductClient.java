package com.mehmetberkan.springfeignclientexample.feign;

import com.mehmetberkan.springfeignclientexample.config.FeignClientConfig;
import com.mehmetberkan.springfeignclientexample.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "http://localhost:8082/api/products", configuration = FeignClientConfig.class)
public interface ProductClient {

    @GetMapping("/{productId}")
    ProductDTO getProductId(@PathVariable("productId") Long productId);
}
