package com.qhit.adminuser.service.basedept;

import com.qhit.adminuser.pojo.BaseDept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/13.
 */
@Repository
public interface BaseDeptService {

    List<BaseDept> getDeptList();
}
