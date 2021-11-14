package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.core.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDao extends JpaRepository<Profile, Integer> {
}
