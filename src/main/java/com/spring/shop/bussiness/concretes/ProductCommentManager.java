package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.ProductCommentService;
import com.spring.shop.dataAccess.abstracts.ProductCommentDao;
import com.spring.shop.entities.ProductComment;
import org.springframework.stereotype.Service;

@Service
public class ProductCommentManager implements ProductCommentService {
    private final ProductCommentDao productCommentDao;

    public ProductCommentManager(ProductCommentDao productCommentDao) {
        this.productCommentDao = productCommentDao;
    }

    @Override
    public void save(ProductComment productComment) {
        this.productCommentDao.save(productComment);
    }
}
