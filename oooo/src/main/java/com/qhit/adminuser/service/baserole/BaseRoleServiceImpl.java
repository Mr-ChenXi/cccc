package com.qhit.adminuser.service.baserole;

import com.qhit.adminuser.dao.baserole.BaseRoleMapper;
import com.qhit.adminuser.pojo.BaseRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/14.
 */
@Service
public class BaseRoleServiceImpl implements BaseRoleService {

    @Autowired
    private BaseRoleMapper baseRoleMapper;
    @Override
    public List<BaseRole> getBaseRoles() {
        return baseRoleMapper.getBaseRoles();
    }

    @Override
    public List<BaseRole> getBaseUserRoles(Integer uid) {
        return baseRoleMapper.getBaseUserRoles(uid);
    }

    @Override
    public List<BaseRole> getNotBaseUserRoles(Integer uid) {
        return baseRoleMapper.getNotBaseUserRoles(uid);
    }
}
