package com.xian.service;

import com.xian.domain.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll();

    void save(Product product);
}
