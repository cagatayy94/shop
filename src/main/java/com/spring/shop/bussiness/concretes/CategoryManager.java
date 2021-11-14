package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.CategoryService;
import com.spring.shop.dataAccess.abstracts.CategoryDao;
import com.spring.shop.entities.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void save(Category category) {
        this.categoryDao.save(category);
    }

    @Override
    public Category getRandom() {
        return this.categoryDao.getRandom();
    }
}
