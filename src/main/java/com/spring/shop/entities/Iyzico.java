package com.spring.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Table(name = "iyzico")
@AllArgsConstructor
@NoArgsConstructor
public class Iyzico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "apiKey")
    private String apiKey;

    @Column(name = "secretKey")
    private String secretKey;

    @Column(name = "baseUrl")
    private String baseUrl;
}
