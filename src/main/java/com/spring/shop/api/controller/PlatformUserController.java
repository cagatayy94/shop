package com.spring.shop.api.controller;

import com.spring.shop.bussiness.abstracts.PlatformUserService;
import com.spring.shop.core.util.JwtTokenUtil;
import com.spring.shop.entities.PlatformUser;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/platform-users/")
public class PlatformUserController {
    private final PlatformUserService platformUserService;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public PlatformUserController(PlatformUserService platformUserService, JwtTokenUtil jwtTokenUtil) {
        this.platformUserService = platformUserService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping("getAll")
    public List<PlatformUser> getAll(){
        return this.platformUserService.getAll();
    }

    @PostMapping("setMobile")
    public ResponseEntity<?> updateMobile(@RequestBody String mobile){
        PlatformUser platformUser = this.platformUserService.getUserDetailsFromRequestHeader();
        platformUser.setMobile(mobile);
        this.platformUserService.save(platformUser);

        Twilio.init("AC55a2a1f54e0a12f462a5c6a263e2b045", "5be5b1b430b13a2391d9aebe3a479007");
        Message message = Message.creator(
                        new PhoneNumber("+905374176999"),
                        new PhoneNumber("+13186665692"),
                        "Lazımmış hemenmiş acilmiş")
                .create();

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
