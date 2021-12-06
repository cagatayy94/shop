package com.spring.shop.api.controller;

import com.spring.shop.bussiness.abstracts.ProductService;
import com.spring.shop.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products/")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping()
    public List<Product> getAll(){
        return this.productService.getAll();
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable Integer id){
        return this.productService.getOne(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        this.productService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<?> save(@RequestBody Product product){
        this.productService.save(product);
        return ResponseEntity.ok().build();
    }




}
