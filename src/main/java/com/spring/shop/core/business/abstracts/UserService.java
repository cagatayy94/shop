package com.spring.shop.core.business.abstracts;

import com.spring.shop.core.entities.Permission;
import com.spring.shop.core.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getFirstByEmail(String email);
    Permission getPermissionFromSlug(String slug);
}
