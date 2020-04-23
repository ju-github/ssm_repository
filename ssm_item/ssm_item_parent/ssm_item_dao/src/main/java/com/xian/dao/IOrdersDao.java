package com.xian.dao;

import com.xian.domain.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IOrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true ,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select="com.xian.dao.IProductDao.findProductById"))
    })
    public List<Orders> findAll();

    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true ,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select="com.xian.dao.IProductDao.findProductById")),
            @Result(column = "id",property = "travellers",many = @Many(select = "com.xian.dao.ITravellerDao.findByOrdersId")),
            @Result(column = "memberId",property = "member",one = @One(select="com.xian.dao.IMemberDao.findById"))
    })
    Orders findById(String id);
}
