package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqDao extends JpaRepository<Faq, Integer> {
}
