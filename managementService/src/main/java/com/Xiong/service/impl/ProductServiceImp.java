package com.Xiong.service.impl;

import com.Xiong.domain.Product;
import com.Xiong.service.ProductService;
import com.Xiong.dao.ProductDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductDao productDao;


    @Override
    public List<Product> findAll(int page, int pagesize) {
        PageHelper.startPage(page, pagesize);
        List<Product> all = productDao.findAll();
        return all;
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}
