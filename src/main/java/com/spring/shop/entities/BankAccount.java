package com.spring.shop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BankAccounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "logo")
    private String logo;

    @Column(name = "country")
    private String country;

    @Column(name = "branchName")
    private String branchName;

    @Column(name = "currency")
    private String currency;

    @Column(name = "city")
    private String city;

    @Column(name = "branchCode")
    private String branchCode;

    @Column(name = "accountOwner")
    private String accountOwner;

    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "iban")
    private String iban;

    @JsonIgnore
    @OneToMany(mappedBy = "bankAccount")
    private List<OrderNotice> orderNotices;
}
