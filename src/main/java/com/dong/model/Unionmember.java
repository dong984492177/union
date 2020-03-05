package com.dong.model;

import java.io.Serializable;

/**
 * (Unionmember)实体类
 *
 * @author makejava
 * @since 2020-03-03 13:32:15
 */
public class Unionmember implements Serializable {
    private static final long serialVersionUID = 116188987839253291L;
    /**
    * id
    */
    private Integer umId;
    /**
    * 工会id
    */
    private Integer umUaId;
    /**
    * 工会创建人id
    */
    private Integer unRId;
    /**
    * 周贡献
    */
    private Integer unWeekContribution;
    /**
    * 月贡献
    */
    private Integer unMonthlyContribution;
    /**
    * 总贡献
    */
    private Integer unTotalContribution;
    /**
    * 职位id
    */
    private Integer unPId;


    public Integer getUmId() {
        return umId;
    }

    public void setUmId(Integer umId) {
        this.umId = umId;
    }

    public Integer getUmUaId() {
        return umUaId;
    }

    public void setUmUaId(Integer umUaId) {
        this.umUaId = umUaId;
    }

    public Integer getUnRId() {
        return unRId;
    }

    public void setUnRId(Integer unRId) {
        this.unRId = unRId;
    }

    public Integer getUnWeekContribution() {
        return unWeekContribution;
    }

    public void setUnWeekContribution(Integer unWeekContribution) {
        this.unWeekContribution = unWeekContribution;
    }

    public Integer getUnMonthlyContribution() {
        return unMonthlyContribution;
    }

    public void setUnMonthlyContribution(Integer unMonthlyContribution) {
        this.unMonthlyContribution = unMonthlyContribution;
    }

    public Integer getUnTotalContribution() {
        return unTotalContribution;
    }

    public void setUnTotalContribution(Integer unTotalContribution) {
        this.unTotalContribution = unTotalContribution;
    }

    public Integer getUnPId() {
        return unPId;
    }

    public void setUnPId(Integer unPId) {
        this.unPId = unPId;
    }

}