package com.spring.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agreementsStrings")
public class AgreementsAndStrings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "aboutUs")
    private String aboutUs;

    @Column(name = "signUpAgreement")
    private String signUpAgreement;

    @Column(name = "termsOfUse")
    private String termsOfUse;

    @Column(name = "confidentialityAgreement")
    private String confidentialityAgreement;

    @Column(name = "distantSalesAgreement")
    private String distantSalesAgreement;

    @Column(name = "deliverables")
    private String deliverables;

    @Column(name = "cancelRefundChange")
    private String cancelRefundChange;
}
