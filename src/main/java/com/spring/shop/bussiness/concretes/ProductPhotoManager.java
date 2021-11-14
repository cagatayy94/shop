package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.ProductPhotoService;
import com.spring.shop.dataAccess.abstracts.ProductPhotoDao;
import com.spring.shop.entities.ProductPhoto;
import org.springframework.stereotype.Service;

@Service
public class ProductPhotoManager implements ProductPhotoService {

    private final ProductPhotoDao productPhotoDao;

    public ProductPhotoManager(ProductPhotoDao productPhotoDao) {
        this.productPhotoDao = productPhotoDao;
    }

    @Override
    public void save(ProductPhoto productPhoto) {
        this.productPhotoDao.save(productPhoto);
    }
}
