package com.qhit.adminuser.dao.BaseUserRole;

import com.qhit.adminuser.pojo.BaseRole;
import com.qhit.adminuser.pojo.BaseUserRole;

import java.util.List;

public interface BaseUserRoleMapper {
    int deleteByPrimaryKey(Integer urid);

    int insert(BaseUserRole record);

    int insertSelective(BaseUserRole record);

    BaseUserRole selectByPrimaryKey(Integer urid);

    int updateByPrimaryKeySelective(BaseUserRole record);

    int updateByPrimaryKey(BaseUserRole record);

    List<BaseRole> getBaseUserRoles(BaseRole baseRole);
}