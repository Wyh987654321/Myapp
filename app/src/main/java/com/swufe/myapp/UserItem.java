package com.swufe.myapp;

public class UserItem {

    private  String number;
    private  String password;
    private  String name;
    private  String intro;
    private  String grade;
    private  String fans;
    private  String rate;
    private  String attention;
    private  Integer money;
    private  int  avatar;

    public UserItem(String number, String password, String name, String intro, String grade, String fans, String rate, String attention, Integer money, int avatar) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.intro = intro;
        this.grade = grade;
        this.fans = fans;
        this.rate = rate;
        this.attention = attention;
        this.money = money;
        this.avatar = avatar;
    }

    public UserItem() {
        number="";
        password="";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
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
