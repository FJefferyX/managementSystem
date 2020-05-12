package com.Xiong.dao;

import com.Xiong.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {

    @Select("select * from product")
    public List<Product> findAll();

    @Select("select * from product where id = #{id}")
    public Product findById(String id);

    /*
    *     @Insert("insert into product(productNum,productName,departureTime,cityName,productPrice,productStatus,productDesc)" +
                "values(#{},#{},#{},#{},#{},#)")
        public int updateProduct(Product product);
    }
    *
    * */
    @Insert("insert into product(id,productNum,productName,departureTime,cityName,productPrice,productStatus,productDesc) " +
            "values(#{id},#{productNum},#{productName},#{departureTime},#{cityName},#{productPrice},#{productStatus},#{productDesc})")
    public void updateProduct(Product product);
}