package com.dong.model;

import java.io.Serializable;

/**
 * (Unionmember)实体类
 *
 * @author makejava
 * @since 2020-03-08 13:14:18
 */
public class Unionmember implements Serializable {
    public static final long serialVersionUID = 794596466366075583L;
    /**
    * id
    */
    public Integer umId;
    /**
    * 工会id
    */
    public Integer umUaId;
    /**
    * 工会成员id
    */
    public Integer unRId;
    /**
    * 周贡献
    */
    public Integer unWeekContribution;
    /**
    * 月贡献
    */
    public Integer unMonthlyContribution;
    /**
    * 总贡献
    */
    public Integer unTotalContribution;
    /**
    * 职位id
    */
    public Integer unPId;


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