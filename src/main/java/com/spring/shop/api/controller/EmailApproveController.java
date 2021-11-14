package com.spring.shop.api.controller;

import com.spring.shop.bussiness.abstracts.PlatformUserService;
import com.spring.shop.entities.PlatformUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
public class EmailApproveController {
    private final PlatformUserService platformUserService;

    @Autowired
    public EmailApproveController(PlatformUserService platformUserService) {
        this.platformUserService = platformUserService;
    }

    @GetMapping("/approve")
    public ResponseEntity<String> approve(@RequestParam(name = "email") String email, @RequestParam(name = "code") String code){
        PlatformUser platformUser = this.platformUserService.getFirstByEmail(email);

        if (platformUser != null && Objects.equals(platformUser.getActivationCode(), code)){
            platformUser.setEmailApproved(true);
            platformUser.setActivationCode(null);
            platformUserService.save(platformUser);

            return new ResponseEntity<String>("Your email approved successfully", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Link expired", HttpStatus.UNAUTHORIZED);
    }
}
