package com.qhit.adminuser.service.admin;

import com.qhit.adminuser.pojo.Adminuser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/12.
 */
@Repository
public interface AdminUserService {
//    添加
    int  insert(Adminuser record);
//    根据ID查询
    Adminuser selectByPrimaryKey(Integer uid);
//    登录
    Adminuser getUserByNameAndPwd(Adminuser record);
//    修改
    int updateByPrimaryKeySelective(Adminuser record);
//    查询
    List<Adminuser> getAdminList();
//    删除
    int deleteByPrimaryKey(Integer uid);

    List<Adminuser> findListByName(Adminuser adminuser);

    void inserts(Integer uid,String[] rids);

    int deleteRid(Integer uid);
}
