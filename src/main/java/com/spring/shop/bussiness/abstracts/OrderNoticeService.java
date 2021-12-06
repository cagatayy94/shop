package com.spring.shop.bussiness.abstracts;

import com.spring.shop.entities.OrderNotice;

import java.util.List;

public interface OrderNoticeService {
    void save(OrderNotice orderNotice);
    List<OrderNotice> getAll();
    OrderNotice getOne(Integer id);
    void delete(Integer id);
}
