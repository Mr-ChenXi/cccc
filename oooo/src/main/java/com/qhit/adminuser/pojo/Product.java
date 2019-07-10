package com.qhit.adminuser.pojo;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private Integer pid;

    private String pname;

    private Double marketprice;

    private Double shopprice;

    private String image;

    private String pdesc;

    private Integer ishot;

    private Date pdate;

    private Integer csid;

    private CategorySecond categorySecond;

    public CategorySecond getCategorySecond() {
        return categorySecond;
    }

    public void setCategorySecond(CategorySecond categorySecond) {
        this.categorySecond = categorySecond;
    }

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(Double marketprice) {
        this.marketprice = marketprice;
    }

    public Double getShopprice() {
        return shopprice;
    }

    public void setShopprice(Double shopprice) {
        this.shopprice = shopprice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }
}