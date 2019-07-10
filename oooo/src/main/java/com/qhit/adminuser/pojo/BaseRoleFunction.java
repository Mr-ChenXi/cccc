package com.qhit.adminuser.pojo;

import java.io.Serializable;

public class BaseRoleFunction implements Serializable {
    private Integer rmid;

    private Integer rid;

    private Integer fid;

    private static final long serialVersionUID = 1L;

    public Integer getRmid() {
        return rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }
}