package com.Xiong.service.impl;

import com.Xiong.dao.OrderDao;
import com.Xiong.domain.Order;
import com.Xiong.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAll(Integer page, Integer pagesize) {
        PageHelper.startPage(page, pagesize);
        List<Order> all = orderDao.findAll();
        return all;
    }

    @Override
    public Order findById(String id) {
        return orderDao.findById(id);
    }
}
