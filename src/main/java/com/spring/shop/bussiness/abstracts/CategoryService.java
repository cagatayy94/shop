package com.spring.shop.bussiness.abstracts;

import com.spring.shop.entities.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    Category getRandom();
    List<Category> findAll();
    Category getById(Integer id);
    void delete(Integer id);
}
