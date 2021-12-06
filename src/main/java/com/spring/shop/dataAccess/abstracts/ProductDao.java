package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    List<Product> findAllByOrderByIdDesc();
}
