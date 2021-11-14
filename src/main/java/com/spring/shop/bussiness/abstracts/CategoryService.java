package com.spring.shop.bussiness.abstracts;

import com.spring.shop.entities.Category;

public interface CategoryService {
    void save(Category category);
    Category getRandom();
}
