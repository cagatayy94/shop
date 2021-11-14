package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address, Integer> {
}
