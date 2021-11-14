package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantDao extends JpaRepository<ProductVariant, Integer> {
}
