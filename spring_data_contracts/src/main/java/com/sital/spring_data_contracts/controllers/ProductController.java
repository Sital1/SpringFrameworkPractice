package com.sital.spring_data_contracts.controllers;

import com.sital.spring_data_contracts.dtos.ProductDTO;
import com.sital.spring_data_contracts.models.Product;
import com.sital.spring_data_contracts.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
    }

    @GetMapping("all")
    public List<Product>  getAllByDescending(){
        return productService.getAllByDescending();
    }


    // paging using pagination
    @GetMapping("/page/{page}")
    public List<Product> getProductsByPage(@PathVariable int page){

        return productService.getProductsByPage(page);
    }

}
