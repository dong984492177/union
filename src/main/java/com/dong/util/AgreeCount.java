package com.dong.util;

public class AgreeCount {
    /**
     * 同意成功数量
     */
    int agree=0;
    /**
     * 拒绝成功数量
     */
    int refuseCount=0;
    /**
     * 失败数量
     */
    int failure=0;

    public AgreeCount() {
    }

    public AgreeCount(int agree, int refuseCount, int failure) {
        this.agree = agree;
        this.refuseCount = refuseCount;
        this.failure = failure;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    public int getRefuseCount() {
        return refuseCount;
    }

    public void setRefuseCount(int refuseCount) {
        this.refuseCount = refuseCount;
    }

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }
}
