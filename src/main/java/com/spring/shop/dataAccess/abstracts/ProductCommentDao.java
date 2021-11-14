package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCommentDao extends JpaRepository<ProductComment, Integer> {
}
