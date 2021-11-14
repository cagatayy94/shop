package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.CargoCompanyService;
import com.spring.shop.dataAccess.abstracts.CargoCompanyDao;
import com.spring.shop.entities.CargoCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoCompanyManager implements CargoCompanyService {
    private final CargoCompanyDao cargoCompanyDao;

    @Autowired
    public CargoCompanyManager(CargoCompanyDao cargoCompanyDao) {
        this.cargoCompanyDao = cargoCompanyDao;
    }

    @Override
    public void save(CargoCompany cargoCompany) {
        this.cargoCompanyDao.save(cargoCompany);
    }
}
