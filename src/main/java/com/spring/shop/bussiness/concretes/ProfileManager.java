package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.ProfileService;
import com.spring.shop.dataAccess.abstracts.ProfileDao;
import com.spring.shop.core.entities.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileManager implements ProfileService {
    private final ProfileDao profileDao;

    @Autowired
    public ProfileManager(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public void save(Profile profile) {
        this.profileDao.save(profile);
    }
}
