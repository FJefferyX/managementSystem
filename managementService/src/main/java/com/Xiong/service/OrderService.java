package com.Xiong.service;

import com.Xiong.domain.Order;

import java.util.List;

public interface OrderService {
    public List<Order> findAll(Integer page, Integer pagesize);

    public Order findById(String id);
}
