package com.example.romananchugov.homeworkapplicationlesson1;

/**
 * Created by romananchugov on 13.10.17.
 */

public class RecyclerElement {
    private String text;
    private int imageUrl;
    private String id;

    public RecyclerElement(String id, int imageUrl, String text){
        this.text = text;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
