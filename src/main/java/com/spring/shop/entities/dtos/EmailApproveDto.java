package com.spring.shop.entities.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailApproveDto {
    String email;
    String code;
}
