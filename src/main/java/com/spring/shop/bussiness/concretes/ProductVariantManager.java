package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.ProductVariantService;
import com.spring.shop.dataAccess.abstracts.ProductVariantDao;
import com.spring.shop.entities.ProductVariant;
import org.springframework.stereotype.Service;

@Service
public class ProductVariantManager implements ProductVariantService {
    private final ProductVariantDao productVariantDao;

    public ProductVariantManager(ProductVariantDao productVariantDao) {
        this.productVariantDao = productVariantDao;
    }

    @Override
    public void save(ProductVariant productVariant) {
        this.productVariantDao.save(productVariant);
    }
}
