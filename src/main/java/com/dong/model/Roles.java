package com.dong.model;

import java.io.Serializable;

/**
 * (Roles)实体类
 *
 * @author makejava
 * @since 2020-03-03 16:52:58
 */
public class Roles implements Serializable {
    private static final long serialVersionUID = -52755974784753335L;
    /**
    * 用户id
    */
    private Integer rId;
    /**
    * 账号
    */
    private String rUser;
    /**
    * 密码
    */
    private String rPassword;
    /**
    * 成员等级
    */
    private Integer rGrade;
    /**
    * 昵称
    */
    private String rUsername;
    /**
    * 金币
    */
    private Long rGold;
    /**
    * 工会id
    */
    private Integer rUaId;
    /**
    * 头像图片路径地址
    */
    private String rImg;


    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public String getRUser() {
        return rUser;
    }

    public void setRUser(String rUser) {
        this.rUser = rUser;
    }

    public String getRPassword() {
        return rPassword;
    }

    public void setRPassword(String rPassword) {
        this.rPassword = rPassword;
    }

    public Integer getRGrade() {
        return rGrade;
    }

    public void setRGrade(Integer rGrade) {
        this.rGrade = rGrade;
    }

    public String getRUsername() {
        return rUsername;
    }

    public void setRUsername(String rUsername) {
        this.rUsername = rUsername;
    }

    public Long getRGold() {
        return rGold;
    }

    public void setRGold(Long rGold) {
        this.rGold = rGold;
    }

    public Integer getRUaId() {
        return rUaId;
    }

    public void setRUaId(Integer rUaId) {
        this.rUaId = rUaId;
    }

    public String getRImg() {
        return rImg;
    }

    public void setRImg(String rImg) {
        this.rImg = rImg;
    }

}