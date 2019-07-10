package com.qhit.adminuser.pojo;

import java.io.Serializable;

public class BaseDept implements Serializable {
    private Integer deptId;

    private String deptName;

    private static final long serialVersionUID = 1L;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}