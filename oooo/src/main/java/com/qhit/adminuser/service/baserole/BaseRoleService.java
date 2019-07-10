package com.qhit.adminuser.service.baserole;

import com.qhit.adminuser.pojo.BaseRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/14.
 */
@Repository
public interface BaseRoleService {

    List<BaseRole> getBaseRoles();

    List<BaseRole> getBaseUserRoles(Integer uid);

    List<BaseRole> getNotBaseUserRoles(Integer uid);
}
