package com.spring.shop.entities;

import com.spring.shop.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adminUsers")
@PrimaryKeyJoinColumn(name = "user_id")
public class AdminUser extends User {
    String role = "ADMIN";
}
