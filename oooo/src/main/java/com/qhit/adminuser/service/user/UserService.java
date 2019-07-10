package com.qhit.adminuser.service.user;

import com.qhit.adminuser.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/13.
 */
@Repository
public interface UserService {

    List<User> getUserList();

    int insertSelective(User record);

    int deleteByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    User selectByPrimaryKey(Integer uid);
}
