package com.sital.springboot101.services;

import com.sital.springboot101.dto.ProductDTO;
import com.sital.springboot101.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void addProduct(ProductDTO productDTO){
        productRepository.addProduct(productDTO);
    }

}
