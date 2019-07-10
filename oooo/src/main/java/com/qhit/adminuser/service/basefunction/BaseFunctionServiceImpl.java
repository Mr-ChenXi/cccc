package com.qhit.adminuser.service.basefunction;

import com.qhit.adminuser.dao.basefunction.BaseFunctionMapper;
import com.qhit.adminuser.pojo.BaseFunction;
import com.qhit.adminuser.pojo.BaseRoleFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 爸爸 on 2019/5/13.
 */
@Service
public class BaseFunctionServiceImpl implements  BaseFunctionService{
    @Autowired
    private BaseFunctionMapper baseFunctionMapper;

    @Override
    public List<BaseFunction> findAll() {
        return baseFunctionMapper.findAll();
    }

    @Override
    public List<BaseFunction> getBaseFunctionNameAndId(Integer rid) {
        return baseFunctionMapper.getBaseFunctionNameAndId(rid);
    }

    @Override
    public List<BaseFunction> getNotBaseFunctionNameAndId(Integer rid) {
        return baseFunctionMapper.getNotBaseFunctionNameAndId(rid);
    }

    @Override
    public void inserts(Integer rid, String[] fids) {
        baseFunctionMapper.deleteBaseRoleByRid(rid);
        List list=new ArrayList();
        if(fids!=null){
            for(String fid:fids){
                BaseRoleFunction baseRoleFunction=new BaseRoleFunction();
                baseRoleFunction.setRid(rid);
                baseRoleFunction.setFid(Integer.parseInt(fid));
                list.add(baseRoleFunction);
            }
            baseFunctionMapper.insertBaseRoleFunction(list);

        }

    }

    @Override
    public List<BaseFunction> findAllByUid(Integer uid) {
        return baseFunctionMapper.findAllByUid(uid);
    }
}
