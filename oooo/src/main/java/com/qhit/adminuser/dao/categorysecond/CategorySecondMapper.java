package com.qhit.adminuser.dao.categorysecond;

import com.qhit.adminuser.pojo.CategorySecond;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorySecondMapper {
    int deleteByPrimaryKey(Integer csid);

    int insert(CategorySecond record);

    int insertSelective(CategorySecond record);

    CategorySecond selectByPrimaryKey(Integer csid);

    int updateByPrimaryKeySelective(CategorySecond record);

    int updateByPrimaryKey(CategorySecond record);

    List<CategorySecond> findAll();
}