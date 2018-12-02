package com.brotuny.proj.data.model;

public class User extends BREntity {

    private String email;
    private String telegram;

    public User(String email, String vk) {
        this.email = email;
        this.telegram = vk;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }
}
