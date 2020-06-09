package com.swufe.myapp;

import android.util.Log;

public class InfroItem {
    private  String number;
    private  String name;
    private  String intro;
    private  String grade;
    private  String fans;
    private  String rate;
    private  String attention;
    private  Integer money;
    private  int  avatar;

    public InfroItem(String number, String name, String intro1, String grade,String attention, String fans, String rate, Integer money,int head) {
        this.number = number;
        this.name = name;
        this.intro = intro1;
        this.grade = grade;
        this.fans = fans;
        this.rate = rate;
        this.attention=attention;
        this.money = money;
        this.avatar= head;
    }

    public InfroItem() {
        number="";
        name="";
        intro="";
        grade="";
        fans="";
        rate="";
        attention="";
        money=0;
        avatar=0;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
