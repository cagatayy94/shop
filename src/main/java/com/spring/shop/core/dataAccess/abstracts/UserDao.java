package com.spring.shop.core.dataAccess.abstracts;

import com.spring.shop.core.entities.Permission;
import com.spring.shop.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    User getFirstByEmail(String email);

    @Query(name = "get_all_permissions", nativeQuery = true)
    List<Permission> getAllPermissions(int adminId);


    @Query(name = "get_permission_from_slug", nativeQuery = true)
    Permission getPermissionFromSlug(String slug);
}
