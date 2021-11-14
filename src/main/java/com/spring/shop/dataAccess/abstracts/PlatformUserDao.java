package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.PlatformUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlatformUserDao extends JpaRepository<PlatformUser, Integer> {
    @Query(nativeQuery=true, value="SELECT *  FROM platform_users pu LEFT JOIN users u ON u.id = pu.user_id  ORDER BY random() LIMIT 1")
    PlatformUser getRandom();
    PlatformUser getFirstByEmail(String email);
}
