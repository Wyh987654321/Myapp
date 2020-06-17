package com.swufe.myapp;

public class MyTasks {
    int id;
    int money;
    int avatar;
    String details;
    String mynumber;
    String employer_id;
    String employer_name;
    String university;
    String status;

    public MyTasks(int id, int money, int avatar, String details, String mynumber,
                          String employer_id, String employer_name, String university) {
        this.id = id;
        this.money = money;
        this.avatar = avatar;
        this.details = details;
        this.mynumber = mynumber;
        this.employer_id = employer_id;
        this.employer_name = employer_name;
        this.university = university;
        this.status = "1";
    }

    public String getMynumber() {
        return mynumber;
    }

    public void setMynumber(String mynumber) {
        this.mynumber = mynumber;
    }

    public  MyTasks(){
        this.id = 0;
        this.money = 0;
        this.details = "";
        mynumber=" ";
        this.employer_id = "";
        this.employer_name = "";
        this.university = "";
        this.status = "";
    }

    public String getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(String employer_id) {
        this.employer_id = employer_id;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}
