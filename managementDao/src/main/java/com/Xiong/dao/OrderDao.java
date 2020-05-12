package com.Xiong.dao;

import com.Xiong.domain.Member;
import com.Xiong.domain.Order;
import com.Xiong.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderDao {
    @Select("select * from orders")
    @Results(id = "Orders", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.Xiong.dao.ProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.Xiong.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = List.class, many = @Many(select = "com.Xiong.dao.TravellerDao.findById")),

    }
    )
    public List<Order> findAll();

    @ResultMap("Orders")
    @Select("select * from orders where id = #{id}")
    public Order findById(String id);
}
