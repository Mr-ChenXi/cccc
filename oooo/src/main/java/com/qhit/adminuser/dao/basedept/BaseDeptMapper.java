package com.qhit.adminuser.dao.basedept;

import com.qhit.adminuser.pojo.BaseDept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(BaseDept record);

    int insertSelective(BaseDept record);

    BaseDept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(BaseDept record);

    int updateByPrimaryKey(BaseDept record);

    List<BaseDept> getDeptList();
}