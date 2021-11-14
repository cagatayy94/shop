package com.spring.shop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.shop.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "platformUsers")
@PrimaryKeyJoinColumn(name = "user_id")
public class PlatformUser extends User {
    @Column(name = "activationCode")
    private String activationCode;

    @Column(name = "ipAddress")
    private String ipAddress;

    @Column(name = "emailApproved")
    private boolean emailApproved;

    @Column(name = "mobileApproved")
    private boolean mobileApproved;

    @Column(name = "unsubscribe")
    private boolean unsubscribe;

    @Column(name = "createdAt")
    private Date createdAt;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "platform_user_favorites",
            joinColumns = @JoinColumn(name = "platform_user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> favoriteProducts;

    @JsonIgnore
    @OneToMany(mappedBy = "platformUser")
    private List<ProductComment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "platformUser")
    private List<Address> addresses;
}
