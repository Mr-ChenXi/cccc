package com.qhit.adminuser.pojo;

import java.io.Serializable;

public class CategorySecond implements Serializable {
    private Integer csid;

    private String csname;

    private Integer cid;

    private  Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private static final long serialVersionUID = 1L;

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}