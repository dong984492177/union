package com.dong.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Application)实体类
 *
 * @author makejava
 * @since 2020-03-10 14:46:49
 */
public class Application implements Serializable {
    private static final long serialVersionUID = -64038241085183412L;
    
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
    /**
    * 申请时间
    */
    @JsonFormat(pattern = "yyyy年MM月dd日",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    private Date aDate;


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

    public Date getADate() {
        return aDate;
    }

    public void setADate(Date aDate) {
        this.aDate = aDate;
    }

}