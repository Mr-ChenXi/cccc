package com.qhit.adminuser.pojo;

import java.io.Serializable;

public class BaseRole implements Serializable {
    private Integer rid;

    private String rname;

    private  BaseUserRole baseUserRole;

    public BaseUserRole getBaseUserRole() {
        return baseUserRole;
    }

    public void setBaseUserRole(BaseUserRole baseUserRole) {
        this.baseUserRole = baseUserRole;
    }

    private static final long serialVersionUID = 1L;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}