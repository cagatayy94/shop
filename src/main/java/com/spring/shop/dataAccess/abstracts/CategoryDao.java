package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    @Query(nativeQuery=true, value="SELECT *  FROM categories c ORDER BY random() LIMIT 1")
    Category getRandom();
    List<Category> findAllByOrderByIdDesc();

}
