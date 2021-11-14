package com.spring.shop.core.entities.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    String name;
    String surname;
    String email;
    String password;
    String passwordRepeat;
    Boolean agreement;
    String ipAddress;
}
