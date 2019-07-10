package com.qhit.adminuser.dao.orderitem;

import com.qhit.adminuser.pojo.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}