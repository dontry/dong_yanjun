package com.monash.users;

/**
 * Created by caidong on 8/05/2017.
 */
public class User {
    private String mUsername;
    private String mPassword;


    public User(String username, String password) {
       mUsername = username;
       mPassword = password;
    }

    public String getmUsername() {
        return mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}

