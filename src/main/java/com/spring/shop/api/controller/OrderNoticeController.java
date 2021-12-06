package com.spring.shop.api.controller;

import com.spring.shop.bussiness.abstracts.OrderNoticeService;
import com.spring.shop.entities.OrderNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-notice/")
public class OrderNoticeController {
    private final OrderNoticeService orderNoticeService;

    @Autowired
    public OrderNoticeController(OrderNoticeService orderNoticeService) {
        this.orderNoticeService = orderNoticeService;
    }

    @GetMapping
    public List<OrderNotice> getAll(){
        return this.orderNoticeService.getAll();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Integer id){
        this.orderNoticeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> save(@RequestBody OrderNotice orderNotice){
        this.orderNoticeService.save(orderNotice);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public OrderNotice getById(@PathVariable Integer id){
        return this.orderNoticeService.getOne(id);
    }
}
