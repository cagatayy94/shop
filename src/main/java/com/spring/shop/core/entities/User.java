package com.spring.shop.core.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    @Column(name = "mobile")
    private String mobile;

    @ManyToMany
    @JoinTable(
            name = "user_profile",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id"))
    List<Profile> profiles;

    public List<Permission> getAllPermissions(){
        List<Permission> permissions = null;
        for (Profile profile:this.profiles) {
            permissions.addAll(profile.getPermissions());
        }
        return permissions;
    }
}
