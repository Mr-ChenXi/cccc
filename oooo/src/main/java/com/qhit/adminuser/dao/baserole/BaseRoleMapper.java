package com.qhit.adminuser.dao.baserole;

import com.qhit.adminuser.pojo.BaseRole;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BaseRoleMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(BaseRole record);

    int insertSelective(BaseRole record);

    BaseRole selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(BaseRole record);

    int updateByPrimaryKey(BaseRole record);

    List<BaseRole> getBaseRoles();

    List<BaseRole> getBaseUserRoles(Integer uid);

    List<BaseRole> getNotBaseUserRoles(Integer uid);
}