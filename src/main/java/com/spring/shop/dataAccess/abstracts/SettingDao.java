package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingDao extends JpaRepository<Setting, Integer> {
}
