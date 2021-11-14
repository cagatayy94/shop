package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.PlatformUserService;
import com.spring.shop.core.auth.PasswordHasher;
import com.spring.shop.core.entities.dtos.RegisterDto;
import com.spring.shop.core.util.JwtTokenUtil;
import com.spring.shop.dataAccess.abstracts.PlatformUserDao;
import com.spring.shop.entities.PlatformUser;
import com.spring.shop.util.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;

@Service
public class PlatformUserManager implements PlatformUserService {

    private final PlatformUserDao platformUserDao;

    private final EmailServiceImpl emailService;

    private final JwtTokenUtil jwtTokenUtil;

    @Value("${project.host}")
    private String host;

    @Autowired
    public PlatformUserManager(PlatformUserDao platformUserDao, EmailServiceImpl emailService, JwtTokenUtil jwtTokenUtil){
        this.platformUserDao = platformUserDao;
        this.emailService = emailService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public List<PlatformUser> getAll() {
        return this.platformUserDao.findAll();
    }

    @Override
    public PlatformUser getRandom() {
        return this.platformUserDao.getRandom();
    }

    @Override
    public void save(PlatformUser platformUser) {
        this.platformUserDao.save(platformUser);
    }

    @Override
    public PlatformUser getFirstByEmail(String email) {
        return this.platformUserDao.getFirstByEmail(email);
    }

    @Override
    public void registerNewUser(RegisterDto registerDto) throws Exception {

        if (!registerDto.getAgreement()){
            throw new Exception("You should except the terms");
        }

        if (!Objects.equals(registerDto.getPassword(), registerDto.getPasswordRepeat())){
            throw new Exception("Passwords not match");
        }

        PlatformUser isThereAnyUserUsingThisEmail = this.platformUserDao.getFirstByEmail(registerDto.getEmail());

        if (isThereAnyUserUsingThisEmail != null){
            throw  new Exception("There is another with this email");
        }

        PlatformUser platformUser = new PlatformUser();

        platformUser.setName(registerDto.getName());
        platformUser.setSurname(registerDto.getSurname());
        platformUser.setEmail(registerDto.getEmail());
        platformUser.setEmailApproved(false);
        platformUser.setIpAddress(registerDto.getIpAddress());
        platformUser.setMobileApproved(false);
        platformUser.setPassword(PasswordHasher.hashString(registerDto.getPassword()));
        platformUser.setDeleted(false);
        platformUser.setActivationCode(UUID.randomUUID().toString());
        platformUser.setCreatedAt(new Date());

        this.save(platformUser);

        String link = "http://"+this.host+"/approve?code="+platformUser.getActivationCode()+"&email="+platformUser.getEmail();

        this.emailService.sendSimpleMessage(platformUser.getEmail(), "Confirm Email","Go to address for confirm your email address " + link);
    }

    public PlatformUser getUserDetailsFromRequestHeader() {
        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization").substring(7);
        String email = jwtTokenUtil.getUsernameFromToken(token);
        return this.platformUserDao.getFirstByEmail(email);
    }
}
