package com.example.github_api.model.repo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("name")
    @Expose
    private String title;

    @SerializedName("stargazers_count")
    @Expose
    private int stars;

    @SerializedName("owner")
    @Expose
    private Owner owner;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getOwner() {
        return owner.getAvatarUrl();
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Repo{" +
                "title='" + title + '\'' +
                ", stars=" + stars +
                ", owner=" + owner +
                '}';
    }
}
