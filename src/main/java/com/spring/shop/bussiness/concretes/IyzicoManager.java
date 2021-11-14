package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.IyzicoService;
import com.spring.shop.dataAccess.abstracts.IyzicoDao;
import com.spring.shop.entities.Iyzico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IyzicoManager implements IyzicoService {
    private final IyzicoDao iyzicoDao;

    @Autowired
    public IyzicoManager(IyzicoDao iyzicoDao) {
        this.iyzicoDao = iyzicoDao;
    }

    @Override
    public void save(Iyzico iyzico) {
        this.iyzicoDao.save(iyzico);
    }
}
