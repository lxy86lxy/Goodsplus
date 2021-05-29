package com.example.Goods.classes;

import android.content.Intent;

import java.util.List;

public class Massage {
    private String name;
    private int imageId;
    private String id;
    private String link;
    private String data;
    private String bottom;
    private Boolean isCheck=false;
    private List<Passage.TagsBean> tagsBeanList;
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public Massage(String name, String id, int imageId, String data, String bottom, List<Passage.TagsBean> tagsBeanList,String link){
//        this.link=link;
        this.tagsBeanList=tagsBeanList;
        this.bottom=bottom;
        this.data=data;
        this.name=name;
        this.id=id;
        this.imageId=imageId;
        this.link=link;

    }

    public String getId() {
        return id;
    }

    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public List<Passage.TagsBean> getTagsBeanList() {
        return tagsBeanList;
    }

    public void setTagsBeanList(List<Passage.TagsBean> tagsBeanList) {
        this.tagsBeanList = tagsBeanList;
    }
}
