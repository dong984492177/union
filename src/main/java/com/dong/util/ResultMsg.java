package com.dong.util;

public class ResultMsg {
    private int  count;
    private String msg;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultMsg() {
    }

    public ResultMsg(int count, String msg) {
        this.count = count;
        this.msg = msg;
    }
}
