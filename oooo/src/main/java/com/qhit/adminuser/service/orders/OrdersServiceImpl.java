package com.qhit.adminuser.service.orders;

import com.qhit.adminuser.dao.orders.OrdersMapper;
import com.qhit.adminuser.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/16.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public List<Orders> findAll() {

        return ordersMapper.findAll();
    }
}
