package com.qhit.adminuser.service.user;

import com.qhit.adminuser.dao.user.UserMapper;
import com.qhit.adminuser.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/13.
 */
@Service
public class UserServiceImpl  implements  UserService{

    @Autowired
    private UserMapper  userMapper;
    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }
}
