package com.zyq.medicinechest.bean;

import java.util.Date;

/**
 * Created by ZYQ on 2016/4/19.
 */
public class UserData {
    private int user_id;
    private String username;
    //    性别，1为男，0为女
    private int gender;
    private Date birthday;
    //    返回的结果码
    private int code;
    private String msg;
    // 会话的ID，保存30分钟
    private String sessionID;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getUsername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", sessionID=" + sessionID +
                '}';
    }

}