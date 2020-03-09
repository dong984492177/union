package com.dong.model;

import java.util.Date;

public class UnionattributesAndRoles {
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
    public Date udDate;

    public Roles roles;

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

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public UnionattributesAndRoles(Integer uaId, String uaName, Integer uaCreateId, Integer uaRank, String uaAnnouncement, Date udDate, Roles roles) {
        this.uaId = uaId;
        this.uaName = uaName;
        this.uaCreateId = uaCreateId;
        this.uaRank = uaRank;
        this.uaAnnouncement = uaAnnouncement;
        this.udDate = udDate;
        this.roles = roles;
    }

    public UnionattributesAndRoles() {
    }
}
