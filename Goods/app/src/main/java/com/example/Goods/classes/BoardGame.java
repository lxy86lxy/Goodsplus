package com.example.Goods.classes;

public class BoardGame {
    private String name;
    private int imageId;
    private String date;
    private String what;
    private String link;
    public BoardGame(String name, int imageId,String date,String what,String link){
        this.name=name;
        this.imageId=imageId;
        this.date=date;
        this.what=what;
        this.link=link;
    }
    public String getLink() {
        return link;
    }

    public String getWhat() {
        return what;
    }

    public String getDate() {
        return date;
    }


    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }


}
