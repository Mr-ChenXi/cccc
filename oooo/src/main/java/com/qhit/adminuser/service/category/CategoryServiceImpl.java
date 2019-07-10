package com.qhit.adminuser.service.category;

import com.qhit.adminuser.dao.category.CategoryMapper;
import com.qhit.adminuser.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/16.
 */
@Service
public class CategoryServiceImpl implements  CategoryService{
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        return categoryMapper.findAll();
    }
}
