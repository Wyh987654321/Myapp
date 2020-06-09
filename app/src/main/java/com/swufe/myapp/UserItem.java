package com.swufe.myapp;

public class UserItem {
    private  int id;
    private  String number;
    private  String password;

    public UserItem(String number, String password) {
        this.number = number;
        this.password = password;
    }

    public UserItem() {
        number ="";
        password ="";
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
