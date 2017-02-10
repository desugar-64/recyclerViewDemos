package com.sergeyfitis.recyclerviewdemo.layout_performance;

/**
 * Created by sergeyfitis on 03.01.17.
 */

public class CommonItem {

    private int color;
    private String title;
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int hashCode() {
        int result = color;
        result = 31 * result + title.hashCode();
        result = 31 * result + body.hashCode();
        return result;
    }
}
