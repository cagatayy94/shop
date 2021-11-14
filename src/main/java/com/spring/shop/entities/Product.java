package com.spring.shop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    @Column(name = "tax")
    private int tax;

    @Column(name = "description")
    private String description;

    @Column(name = "variantTitle")
    private String variantTitle;

    @Column(name = "cargoPrice")
    private int cargoPrice;

    @Column(name = "view")
    private int view;

    @OneToMany(mappedBy = "product")
    private List<ProductPhoto> photos;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "productCategory",
            joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private List<Category> categories;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductComment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductVariant> variants;

    @JsonIgnore
    @ManyToMany(mappedBy = "favoriteProducts")
    private List<PlatformUser> likedUsers;
}
