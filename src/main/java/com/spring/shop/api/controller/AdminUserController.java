package com.spring.shop.api.controller;

import com.spring.shop.bussiness.abstracts.AdminUserService;
import com.spring.shop.core.business.abstracts.UserService;
import com.spring.shop.core.util.JwtTokenUtil;
import com.spring.shop.entities.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/admin-users/")
public class AdminUserController {
    private final AdminUserService adminUserService;
    private final HttpServletRequest request;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AdminUserController(AdminUserService adminUserService, UserService userService, HttpServletRequest request, JwtTokenUtil jwtTokenUtil) {
        this.adminUserService = adminUserService;
        this.request = request;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping()
    public List<AdminUser> getAll() throws AccessDeniedException {
        this.jwtTokenUtil.authorize(this.request,"adminUser_getAll");
        return adminUserService.getAll();
    }
}
