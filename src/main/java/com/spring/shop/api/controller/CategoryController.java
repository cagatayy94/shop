package com.spring.shop.api.controller;

import com.spring.shop.bussiness.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.shop.entities.Category;

import java.util.List;

@RestController
@RequestMapping("/category/")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAll(){
        return this.categoryService.findAll();
    }

    @PutMapping
    public ResponseEntity<?> save(@RequestBody Category category){
        this.categoryService.save(category);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}/")
    public Category get(@PathVariable("id") Integer id){
        return this.categoryService.getById(id);
    }

    @DeleteMapping(value = "{id}/")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        this.categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
