package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.AdminUserService;
import com.spring.shop.dataAccess.abstracts.AdminUserDao;
import com.spring.shop.entities.AdminUser;
import com.spring.shop.core.entities.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminUserManager implements AdminUserService {

    private final AdminUserDao adminUserDao;

    @Autowired
    public AdminUserManager(AdminUserDao adminUserDao){
        this.adminUserDao = adminUserDao;
    }

    @Override
    public List<AdminUser> getAll() {
        return adminUserDao.findAll();
    }

    @Override
    public void save(AdminUser adminUser) {
        this.adminUserDao.save(adminUser);
    }

    @Override
    public AdminUser getFirstByEmail(String email) {
        return this.adminUserDao.getFirstByEmail(email);
    }

    @Override
    public List<Permission> getAllPermissionsByAdminId(int adminId) {
        return this.adminUserDao.getAllPermissions(adminId);
    }
}
