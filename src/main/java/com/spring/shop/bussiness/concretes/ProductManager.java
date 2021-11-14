package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.ProductService;
import com.spring.shop.dataAccess.abstracts.ProductDao;
import com.spring.shop.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }

    @Override
    public void save(Product product) {
        this.productDao.save(product);
    }
}
