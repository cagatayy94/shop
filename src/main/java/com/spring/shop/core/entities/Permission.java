package com.spring.shop.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NamedNativeQuery(
        name = "get_all_permissions",
        query = "SELECT p2.id, p2.name, p2.slug FROM admin_users au LEFT JOIN admin_user_profile aup on au.user_id = aup.admin_user_id LEFT JOIN profiles p on aup.profile_id = p.id LEFT JOIN profile_permissions pp on p.id = pp.profile_id LEFT JOIN permissions p2 on pp.permission_id = p2.id WHERE au.user_id = :adminId",
        resultSetMapping = "permission_mapper"
)
@NamedNativeQuery(
        name = "get_permission_from_slug",
        query = "SELECT p.id, p.name, p.slug FROM permissions p WHERE p.slug = :slug",
        resultSetMapping = "permission_mapper"
)
@SqlResultSetMapping(
        name = "permission_mapper",
        classes = @ConstructorResult(
                targetClass = Permission.class,
                columns = {
                        @ColumnResult(name = "id", type = int.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "slug", type = String.class)
                }
        )
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "slug")
    private String slug;
}
