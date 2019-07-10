package com.qhit.adminuser.pojo;

import java.io.Serializable;

public class BaseUserRole implements Serializable {
    private Integer urid;

    private Integer uid;

    private Integer rid;

    private static final long serialVersionUID = 1L;

    public Integer getUrid() {
        return urid;
    }

    public void setUrid(Integer urid) {
        this.urid = urid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}