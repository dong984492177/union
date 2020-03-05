package com.dong.model;

import java.io.Serializable;

/**
 * (Unionattributes)实体类
 *
 * @author makejava
 * @since 2020-03-03 13:32:11
 */
public class Unionattributes implements Serializable {
    private static final long serialVersionUID = -82288983477894064L;
    /**
    * 工会id
    */
    private Integer uaId;
    /**
    * 工会名字
    */
    private String uaName;
    /**
    * 工会创建人id
    */
    private Integer uaCreateId;
    /**
    * 工会等级
    */
    private Integer uaRank;
    /**
    * 工会公告
    */
    private String uaAnnouncement;


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

}