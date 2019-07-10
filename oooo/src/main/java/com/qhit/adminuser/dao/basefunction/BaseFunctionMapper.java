package com.qhit.adminuser.dao.basefunction;

import com.qhit.adminuser.pojo.BaseFunction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseFunctionMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(BaseFunction record);

    int insertSelective(BaseFunction record);

    BaseFunction selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(BaseFunction record);

    int updateByPrimaryKey(BaseFunction record);

    //无权限
    List<BaseFunction> findAll();
    //有权限
    List<BaseFunction> findAllByUid(Integer uid);

    List<BaseFunction> getBaseFunctionNameAndId(Integer rid);

    List<BaseFunction> getNotBaseFunctionNameAndId(Integer rid);

    int deleteBaseRoleByRid(Integer rid);

    void insertBaseRoleFunction(List list);
}