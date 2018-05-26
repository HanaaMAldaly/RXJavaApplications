package com.triplanner.iti.startingrxjava.Day3.entities;

/**
 * Created by Hanaa on 5/20/2018.
 */

public class Post {
    private int userId;

    public int getUserId() { return this.userId; }

    public void setUserId(int userId) { this.userId = userId; }

    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String title;

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }

    private String body;

    public String getBody() { return this.body; }

    public void setBody(String body) { this.body = body; }
}
