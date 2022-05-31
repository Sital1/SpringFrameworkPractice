package com.sital.unittest.services;

import com.sital.unittest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<String> getProductWithEvenNumberOfCharacters() {
//        List<String> names = productRepository.getProductNames();
//        List<String> result = new ArrayList<>();
//
//        for (String n : names) {
//            if (n.length() % 2 == 0) {
//                result.add(n);
////                productRepository.addProduct(n);
//            }
//        }
//
//        return result;

        return productRepository.getProductNames().stream()
                .filter(x -> x.length() % 2 == 0)
                .collect(Collectors.toList());
    }

}
