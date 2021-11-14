package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.AddressService;
import com.spring.shop.dataAccess.abstracts.AddressDao;
import com.spring.shop.entities.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressManager implements AddressService {

    private final AddressDao addressDao;

    public AddressManager(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public void save(Address address) {
        this.addressDao.save(address);
    }
}
