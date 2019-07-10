package com.qhit.adminuser.service.admin;

import com.qhit.adminuser.dao.admin.AdminuserMapper;
import com.qhit.adminuser.pojo.Adminuser;
import com.qhit.adminuser.pojo.BaseUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 爸爸 on 2019/5/12.
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminuserMapper adminuserMapper;

    @Override
    public int insert(Adminuser record) {
        return adminuserMapper.insert(record);
    }

    @Override
    public Adminuser selectByPrimaryKey(Integer uid) {
        return adminuserMapper.selectByPrimaryKey(uid);
    }

    @Override
    public Adminuser getUserByNameAndPwd(Adminuser record) {
        return adminuserMapper.getUserByNameAndPwd(record);
    }

    @Override
    public  int updateByPrimaryKeySelective(Adminuser record){
        int i = adminuserMapper.updateByPrimaryKeySelective(record);
        return i;
    }

    @Override
    public List<Adminuser> getAdminList() {
        return adminuserMapper.getAdminList();
    }

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return adminuserMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public List<Adminuser> findListByName(Adminuser adminuser) {
        return adminuserMapper.findListByName(adminuser);
    }

    @Override
    public void inserts(Integer uid, String[] rids) {
        adminuserMapper.deleteRid(uid);
        List list=new ArrayList();
        if(rids!=null){
            for(String rid:rids){
                BaseUserRole baseUserRole=new BaseUserRole();
                baseUserRole.setUid(uid);
                baseUserRole.setRid(Integer.parseInt(rid));
                list.add(baseUserRole);
            }

            adminuserMapper.inserts(list);
        }
    }

    @Override
    public int deleteRid(Integer uid) {
       int i = adminuserMapper.deleteRid(uid);
        return 0;
    }

}
