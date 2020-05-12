package com.Xiong.service;

import com.Xiong.domain.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll(int page, int pagesize);

    public void updateProduct(Product product);
}
