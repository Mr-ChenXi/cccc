package com.qhit.adminuser.service.basedept;

import com.qhit.adminuser.dao.basedept.BaseDeptMapper;
import com.qhit.adminuser.pojo.BaseDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/13.
 */
@Service
public class BaseDeptServiceImpl implements  BaseDeptService{
    @Autowired
    private BaseDeptMapper baseDeptMapper;
    @Override
    public List<BaseDept> getDeptList() {
        return baseDeptMapper.getDeptList();
    }
}
