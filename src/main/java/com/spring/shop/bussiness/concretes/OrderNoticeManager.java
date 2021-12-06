package com.spring.shop.bussiness.concretes;

import com.spring.shop.bussiness.abstracts.OrderNoticeService;
import com.spring.shop.dataAccess.abstracts.OrderNoticeDao;
import com.spring.shop.entities.OrderNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderNoticeManager implements OrderNoticeService {
    private final OrderNoticeDao orderNoticeDao;

    @Autowired
    public OrderNoticeManager(OrderNoticeDao orderNoticeDao) {
        this.orderNoticeDao = orderNoticeDao;
    }

    @Override
    public void save(OrderNotice orderNotice) {
        this.orderNoticeDao.save(orderNotice);
    }

    @Override
    public List<OrderNotice> getAll() {
        return this.orderNoticeDao.findAllByOrderByIdDesc();
    }

    @Override
    public OrderNotice getOne(Integer id) {
        return this.orderNoticeDao.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        this.orderNoticeDao.deleteById(id);
    }
}
