package com.dong.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Unionattributes)实体类
 *
 * @author makejava
 * @since 2020-03-08 15:12:44
 */
public class Unionattributes implements Serializable {
    private static final long serialVersionUID = 995991952144832526L;
    /**
    * 工会id
    */
    public Integer uaId;
    /**
    * 工会名字
    */
    public String uaName;
    /**
    * 工会创建人id
    */
    public Integer uaCreateId;
    /**
    * 工会等级
    */
    public Integer uaRank;
    /**
    * 工会公告
    */
    public String uaAnnouncement;
    /**
    * 公会创建时间
    */
    @JsonFormat(pattern = "yyyy年MM月dd日",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    public Date udDate;


    public Integer getUaId() {
        return uaId;
    }

    public void setUaId(Integer uaId) {
        this.uaId = uaId;
    }

    public String getUaName() {
        return uaName;
    }

    public void setUaName(String uaName) {
        this.uaName = uaName;
    }

    public Integer getUaCreateId() {
        return uaCreateId;
    }

    public void setUaCreateId(Integer uaCreateId) {
        this.uaCreateId = uaCreateId;
    }

    public Integer getUaRank() {
        return uaRank;
    }

    public void setUaRank(Integer uaRank) {
        this.uaRank = uaRank;
    }

    public String getUaAnnouncement() {
        return uaAnnouncement;
    }

    public void setUaAnnouncement(String uaAnnouncement) {
        this.uaAnnouncement = uaAnnouncement;
    }

    public Date getUdDate() {
        return udDate;
    }

    public void setUdDate(Date udDate) {
        this.udDate = udDate;
    }

}