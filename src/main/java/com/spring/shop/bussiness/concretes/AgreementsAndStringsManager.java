package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.AgreementsAndStringsService;
import com.spring.shop.dataAccess.abstracts.AgreementsAndStringsDao;
import com.spring.shop.entities.AgreementsAndStrings;
import org.springframework.stereotype.Service;

@Service
public class AgreementsAndStringsManager implements AgreementsAndStringsService {
    private final AgreementsAndStringsDao agreementsAndStringsDao;

    public AgreementsAndStringsManager(AgreementsAndStringsDao agreementsAndStringsDao) {
        this.agreementsAndStringsDao = agreementsAndStringsDao;
    }

    @Override
    public void save(AgreementsAndStrings agreementsAndStrings) {
        this.agreementsAndStringsDao.save(agreementsAndStrings);
    }
}
