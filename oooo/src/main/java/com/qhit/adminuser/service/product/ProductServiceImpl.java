package com.qhit.adminuser.service.product;

import com.qhit.adminuser.dao.product.ProductMapper;
import com.qhit.adminuser.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/15.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }
}
