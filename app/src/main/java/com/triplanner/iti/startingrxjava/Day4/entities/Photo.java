package com.triplanner.iti.startingrxjava.Day4.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hanaa on 5/25/2018.
 */

public class Photo {
    @SerializedName("albumId")
    @Expose
    private int albumId;

    public int getAlbumId() { return this.albumId; }

    public void setAlbumId(int albumId) { this.albumId = albumId; }

    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String title;

    public String getTitle() { return this.title; }

    public void setTitle(String title) { this.title = title; }

    private String url;

    public String getUrl() { return this.url; }

    public void setUrl(String url) { this.url = url; }

    private String thumbnailUrl;

    public String getThumbnailUrl() { return this.thumbnailUrl; }

    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }
}
