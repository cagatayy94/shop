package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.ProductPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPhotoDao extends JpaRepository<ProductPhoto, Integer> {
}
