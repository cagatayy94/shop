package com.spring.shop.bussiness.abstracts;

import com.spring.shop.core.entities.dtos.RegisterDto;
import com.spring.shop.entities.PlatformUser;
import java.util.List;

public interface PlatformUserService {
    List<PlatformUser> getAll();
    PlatformUser getRandom();
    void save(PlatformUser platformUser);
    PlatformUser getFirstByEmail(String email);
    void registerNewUser(RegisterDto registerDto) throws Exception;
    PlatformUser getUserDetailsFromRequestHeader();
}
