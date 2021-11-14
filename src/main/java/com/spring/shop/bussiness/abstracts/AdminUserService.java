package com.spring.shop.bussiness.abstracts;

import com.spring.shop.entities.AdminUser;
import com.spring.shop.core.entities.Permission;

import java.util.List;

public interface AdminUserService {
    List<AdminUser> getAll();
    void save(AdminUser adminUser);
    AdminUser getFirstByEmail(String email);
    List<Permission> getAllPermissionsByAdminId(int adminId);
}
