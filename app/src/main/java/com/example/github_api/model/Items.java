package com.example.github_api.model;

public class Items {
    private String mHeader;
    private String mStars;
    private String mImageUrl;

    public  Items(String imageUrl, String header, String stars){
        mImageUrl = imageUrl;
        mHeader = header;
        mStars = stars;
    }

    public String getImageUrl(){
        return mImageUrl;
    }
    public String getHeader(){
        return mHeader;
    }
    public String getStars(){
        return mStars;
    }

}
