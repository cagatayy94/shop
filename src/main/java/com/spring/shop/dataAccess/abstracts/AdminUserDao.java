package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.AdminUser;
import com.spring.shop.core.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminUserDao extends JpaRepository <AdminUser, Integer> {
    AdminUser getFirstByEmail(String string);

    @Query(name = "get_all_permissions", nativeQuery = true)
    List<Permission> getAllPermissions(int adminId);
}
