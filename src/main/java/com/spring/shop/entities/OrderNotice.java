package com.spring.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderNotices")
public class OrderNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "message")
    private String message;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    @Column(name = "isApproved")
    private boolean isApproved;

    @Column(name = "createdAt")
    private Date createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankAccountId", referencedColumnName = "id")
    private BankAccount bankAccount;
}
