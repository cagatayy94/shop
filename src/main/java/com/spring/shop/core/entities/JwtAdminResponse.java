package com.spring.shop.core.entities;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtAdminResponse {
    String token;
    String permissions;
}
