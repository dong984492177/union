package com.dong.model;

import java.io.Serializable;

/**
 * (Application)实体类
 *
 * @author makejava
 * @since 2020-03-03 13:32:08
 */
public class Application implements Serializable {
    private static final long serialVersionUID = 521409313114289246L;
    
    private Integer aId;
    /**
    * 成员id
    */
    private Integer aRId;
    /**
    * 申请的工会id
    */
    private Integer aUaId;
    /**
    * 操作的人id
    */
    private Integer aOperatingId;
    /**
    * 申请状态 1表示未操作 2表示拒绝
    */
    private Integer aApplicationStatus;


    public Integer getAId() {
        return aId;
    }

    public void setAId(Integer aId) {
        this.aId = aId;
    }

    public Integer getARId() {
        return aRId;
    }

    public void setARId(Integer aRId) {
        this.aRId = aRId;
    }

    public Integer getAUaId() {
        return aUaId;
    }

    public void setAUaId(Integer aUaId) {
        this.aUaId = aUaId;
    }

    public Integer getAOperatingId() {
        return aOperatingId;
    }

    public void setAOperatingId(Integer aOperatingId) {
        this.aOperatingId = aOperatingId;
    }

    public Integer getAApplicationStatus() {
        return aApplicationStatus;
    }

    public void setAApplicationStatus(Integer aApplicationStatus) {
        this.aApplicationStatus = aApplicationStatus;
    }

}