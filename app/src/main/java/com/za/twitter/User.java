package com.za.twitter;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class User implements Serializable {

    @SerializedName("id")
    String id;

    @SerializedName("email")
    String email;

    @SerializedName("first_name")
    String firstName;

    @SerializedName("last_name")
    String lastName;

    @SerializedName("avatar")
    String avatar;

    public User(String email, String firstName, String lastName, String avatar) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
