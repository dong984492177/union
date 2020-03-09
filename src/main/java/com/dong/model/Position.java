package com.dong.model;

import java.io.Serializable;

/**
 * (Position)实体类
 *
 * @author makejava
 * @since 2020-03-02 11:45:19
 */
public class Position implements Serializable {
    private static final long serialVersionUID = -70548284381158849L;
    /**
    * 职位id
    */
    public Integer pId;
    /**
    * 职位名字
    */
    public String pName;


    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

}