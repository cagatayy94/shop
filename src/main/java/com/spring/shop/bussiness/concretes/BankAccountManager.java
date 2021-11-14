package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.BankAccountService;
import com.spring.shop.dataAccess.abstracts.BankAccountDao;
import com.spring.shop.entities.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountManager implements BankAccountService {
    private final BankAccountDao bankAccountsDao;

    @Autowired
    public BankAccountManager(BankAccountDao bankAccountsDao) {
        this.bankAccountsDao = bankAccountsDao;
    }

    @Override
    public void save(BankAccount bankAccount) {
        this.bankAccountsDao.save(bankAccount);
    }

    @Override
    public BankAccount getFirst() {
        return this.bankAccountsDao.findAll().get(0);
    }
}
