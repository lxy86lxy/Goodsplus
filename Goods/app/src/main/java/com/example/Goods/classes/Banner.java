package com.example.Goods.classes;

import java.io.Serializable;

public class Banner implements Serializable {

    /**
     * desc : 扔物线
     * id : 29
     * imagePath : https://wanandroid.com/blogimgs/31c2394c-b07c-4699-afd1-95aa7a3bebc6.png
     * isVisible : 1
     * order : 0
     * title : View 嵌套太深会卡？来用 Jetpack Compose，随便套&mdash;&mdash;Compose 的 Intrinsic Measurement
     * type : 0
     * url : https://www.bilibili.com/video/BV1ZA41137gr
     */

    private String desc;
    private int id;
    private String imagePath;
    private int isVisible;
    private int order;
    private String title;
    private int type;
    private String url;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
