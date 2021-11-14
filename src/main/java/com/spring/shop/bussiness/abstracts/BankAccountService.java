package com.spring.shop.bussiness.abstracts;

import com.spring.shop.entities.BankAccount;

public interface BankAccountService {
    void save(BankAccount bankAccount);
    BankAccount getFirst();
}
