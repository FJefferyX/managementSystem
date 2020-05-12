package com.Xiong.dao;

import com.Xiong.domain.Traveller;
import org.apache.ibatis.annotations.Select;

public interface TravellerDao {
    @Select(("select * from traveller where id in (select travellerId from order_traveller where orderId=#{id}) "))
    public Traveller findById(String id);
}
