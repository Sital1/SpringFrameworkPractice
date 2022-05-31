package com.sital.springboot101.repositories;

import com.sital.springboot101.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addProduct(ProductDTO productDTO){
        String sql = "INSERT INTO product VALUES(NULL,?,?)";
        jdbcTemplate.update(sql,productDTO.getName(), productDTO.getPrice());
    }

}
