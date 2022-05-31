package com.sital.springboot101.controller;

import com.sital.springboot101.dto.ProductDTO;
import com.sital.springboot101.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
    }
}
