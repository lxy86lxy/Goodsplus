package com.example.Goods.classes;

public class BannerRecycle {
    private int image;
    private String link;
 public BannerRecycle(int image,String link){
     this.image=image;
     this.link=link;
 }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
