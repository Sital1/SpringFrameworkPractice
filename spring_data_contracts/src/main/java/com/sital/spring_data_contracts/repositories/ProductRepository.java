package com.sital.spring_data_contracts.repositories;

import com.sital.spring_data_contracts.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findProductByName(String name);

}
