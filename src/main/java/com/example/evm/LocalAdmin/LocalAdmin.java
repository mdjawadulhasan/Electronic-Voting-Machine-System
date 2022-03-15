package com.example.evm.LocalAdmin;

import java.time.Instant;


public class LocalAdmin {


    private String username;
    private String password;
    private String areacode;


    public LocalAdmin() {
    }

    public LocalAdmin(String username, String password, String areacode) {

        this.username = username;
        this.password = password;
        this.areacode=areacode;

    }

    public LocalAdmin(String username, String password) {
        this.username = username;
        this.password = password;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }
}
