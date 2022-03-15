package com.example.evm.Candidate;

public class Candidates {

    private int id;
    private String name;
    private String username;
    private String areacode;
    private int age;
    private String gender;
    private String email;
    private String pass;
    private int IsActive;

    public Candidates() {

    }


    public Candidates(String username,  String pass,String email) {
        this.username = username;
        this.email = email;
        this.pass = pass;
    }

    public Candidates(String name, String username, String areacode, int age, String gender, String email, String pass, int isActive) {
        this.name = name;
        this.username = username;
        this.areacode = areacode;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.pass = pass;
        this.IsActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsActive() {
        return IsActive;
    }

    public void setIsActive(int isActive) {
        IsActive = isActive;
    }

    public Candidates(String name, String areacode, int age, String gender, int id) {
        this.name = name;
        this.areacode = areacode;
        this.age = age;
        this.gender = gender;
        this.id=id;

    }
}
