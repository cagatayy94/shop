package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerDao extends JpaRepository<Banner, Integer> {
}
