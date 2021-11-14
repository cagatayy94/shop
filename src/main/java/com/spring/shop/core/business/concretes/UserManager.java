package com.spring.shop.core.business.concretes;

import com.spring.shop.core.business.abstracts.UserService;
import com.spring.shop.core.dataAccess.abstracts.UserDao;
import com.spring.shop.core.entities.Permission;
import com.spring.shop.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getFirstByEmail(String email) {
        return this.userDao.getFirstByEmail(email);
    }

    @Override
    public Permission getPermissionFromSlug(String slug) {
        return this.userDao.getPermissionFromSlug(slug);
    }
}
