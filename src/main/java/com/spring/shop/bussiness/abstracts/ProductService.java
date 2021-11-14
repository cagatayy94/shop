package com.spring.shop.bussiness.abstracts;

import com.spring.shop.entities.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void save(Product product);
}
