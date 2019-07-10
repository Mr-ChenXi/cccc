package com.qhit.adminuser.service.categorysecond;

import com.qhit.adminuser.dao.categorysecond.CategorySecondMapper;
import com.qhit.adminuser.pojo.CategorySecond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/16.
 */
@Service
public class CategorySecondServiceImpl implements  CategorySecondService {

    @Autowired
    private CategorySecondMapper categorySecondMapper;


    @Override
    public List<CategorySecond> findAll() {
        return categorySecondMapper.findAll();
    }
}
