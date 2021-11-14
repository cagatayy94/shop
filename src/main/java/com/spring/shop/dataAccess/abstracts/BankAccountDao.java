package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountDao extends JpaRepository<BankAccount, Integer> {
}
