package com.spring.shop.dataAccess.abstracts;

import com.spring.shop.entities.OrderNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderNoticeDao extends JpaRepository<OrderNotice, Integer>{
    public List<OrderNotice> findAllByOrderByIdDesc();
}
