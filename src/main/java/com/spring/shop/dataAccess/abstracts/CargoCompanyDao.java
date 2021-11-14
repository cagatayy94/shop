package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.CargoCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoCompanyDao extends JpaRepository<CargoCompany, Integer> {
}
