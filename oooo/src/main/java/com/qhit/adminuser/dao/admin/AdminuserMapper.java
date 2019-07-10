package com.qhit.adminuser.dao.admin;


import com.qhit.adminuser.pojo.Adminuser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface   AdminuserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Adminuser record);

    int insertSelective(Adminuser record);

    Adminuser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Adminuser record);

    int updateByPrimaryKey(Adminuser record);

    Adminuser getUserByNameAndPwd(Adminuser record);

    List<Adminuser> getAdminList();

    List<Adminuser> findListByName(Adminuser adminuser);

    void  inserts(List list);


    int deleteRid(Integer uid);
}