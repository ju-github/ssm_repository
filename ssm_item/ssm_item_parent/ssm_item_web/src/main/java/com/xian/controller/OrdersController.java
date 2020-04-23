package com.xian.controller;

import com.github.pagehelper.PageInfo;

import com.xian.domain.Orders;
import com.xian.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;
    @RequestMapping(value = "/findAll")
    public String findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "4") int size, Model model){
        List<Orders> ordersList = ordersService.findAll(page,size);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);  //这里的ordersList在pageInfo中是list属性
        model.addAttribute("pageInfo",pageInfo);
        return "orders-list";
    }

    @RequestMapping(value = "/findById")
    public String findById(String id, Model model){
         Orders orders=ordersService.findById(id);
         model.addAttribute("orders", orders);
         return "orders-show";
    }
}
