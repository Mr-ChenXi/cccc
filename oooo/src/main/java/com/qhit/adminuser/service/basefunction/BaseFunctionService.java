package com.qhit.adminuser.service.basefunction;

import com.qhit.adminuser.pojo.BaseFunction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/13.
 */
@Repository
public interface BaseFunctionService {

    List<BaseFunction> findAll();

    List<BaseFunction> getBaseFunctionNameAndId(Integer rid);

    List<BaseFunction> getNotBaseFunctionNameAndId(Integer rid);

    void inserts(Integer rid, String[] fids);

    List<BaseFunction> findAllByUid(Integer uid);
}
