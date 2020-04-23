package com.xian.service.impl;

import com.github.pagehelper.PageHelper;
import com.xian.dao.IOrdersDao;
import com.xian.domain.Orders;
import com.xian.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersSericeImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;
    @Override
    public List<Orders> findAll(int page,int size) {
        //pageNum表示页码值，pageSize表示每页显示条数。必须写在真正调用页码的代码之前。
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
