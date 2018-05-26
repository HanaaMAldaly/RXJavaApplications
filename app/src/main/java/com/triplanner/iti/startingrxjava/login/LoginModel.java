package com.triplanner.iti.startingrxjava.login;

/**
 * Created by Hanaa on 5/18/2018.
 */

public class LoginModel {
    public Boolean login(String username,String password){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
