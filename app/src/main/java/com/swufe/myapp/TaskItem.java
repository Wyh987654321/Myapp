package com.swufe.myapp;

public class TaskItem {
    private int id;
    private  String number;
    private  String details;
    private  int reward;
    private  int people;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private  String status;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }



    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public TaskItem(String number, String details, int reward, int people) {
        this.number = number;
        this.details = details;

        this.reward = reward;
        this.people = people;
        status="1";
    }
    public TaskItem(){
        number="";
        details="";
        people=0;
        reward=0;
        status="1";
    }

}

