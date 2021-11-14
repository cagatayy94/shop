package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.AgreementsAndStrings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementsAndStringsDao extends JpaRepository<AgreementsAndStrings, Integer> {
}
