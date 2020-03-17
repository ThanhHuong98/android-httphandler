package com.za.twitter;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class UserWrapper implements Serializable {
    @SerializedName("data")
    ArrayList<User> users;

    @SerializedName("page")
    int page;
    @SerializedName("per_page")
    int per_page;
    @SerializedName("total")
    int total;
    @SerializedName("total_pages")
    int total_pages;

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
