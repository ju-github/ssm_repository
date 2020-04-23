package com.xian.service;

import com.xian.domain.Orders;

import java.util.List;

public interface IOrdersService {
    public List<Orders> findAll(int page,int size);

    Orders findById(String id);
}
