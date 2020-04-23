package com.xian.dao;

import com.xian.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductDao {
    @Select("select * from product")
    public List<Product> findAll();
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice}," +
            "#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("select * from product where id=#{id}")
    public Product findProductById(String id);
}
