package com.example.lihang.viewpagertest;

/**
 * Created by lihang on 2017/3/17.
 */

public class Chat {
    private int imgId;
    private String name;
    private String content;
    public Chat(int imgId,String name,String content){
        this.imgId=imgId;
        this.name=name;
        this.content=content;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
