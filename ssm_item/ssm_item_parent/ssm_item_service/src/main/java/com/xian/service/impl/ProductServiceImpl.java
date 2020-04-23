package com.xian.service.impl;

import com.xian.dao.IProductDao;
import com.xian.domain.Product;
import com.xian.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll() {
        List<Product> productList = productDao.findAll();
        return productList;
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

}
