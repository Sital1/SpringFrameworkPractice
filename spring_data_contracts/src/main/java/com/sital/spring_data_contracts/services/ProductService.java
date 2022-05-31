package com.sital.spring_data_contracts.services;

import com.sital.spring_data_contracts.dtos.ProductDTO;
import com.sital.spring_data_contracts.models.Product;
import com.sital.spring_data_contracts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        productRepository.save(product);

    }

    public List<Product> getAllByDescending() {
        return productRepository.findAll(Sort.by("id").descending());
    }

    // Paging
    public List<Product> getProductsByPage(int page){
        Sort s = Sort.by("id").ascending();
        return productRepository.findAll(PageRequest.of(page,2,s)).getContent();
    }

}
