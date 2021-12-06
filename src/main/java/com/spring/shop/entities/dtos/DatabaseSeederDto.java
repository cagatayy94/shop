package com.spring.shop.entities.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseSeederDto {
    private int numberOfCategoryToBeCreated;
    private int numberOfUserToBeCreated;
    private int numberOfProductsToBeCreated;
    private int numberOfOrderNoticeToBeCreated;
}
