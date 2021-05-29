package com.example.Goods.classes;

import java.io.Serializable;
import java.util.List;

//implements Parcelable

public class Passage implements Serializable {

    /**
        "apkLink": "",
            "audit": 1,
            "author": "郭霖",
            "canEdit": false,
            "chapterId": 409,
            "chapterName": "郭霖",
            "collect": false,
            "courseId": 13,
            "desc": "",
            "descMd": "",
            "envelopePic": "",
            "fresh": false,
            "host": "",
            "id": 18121,
            "link": "https://mp.weixin.qq.com/s/x6tTl2_ns6oIkenq92vcbA",
            "niceDate": "2021-04-29 00:00",
            "niceShareDate": "2021-04-29 23:44",
            "origin": "",
            "prefix": "",
            "projectLink": "",
            "publishTime": 1619625600000,
            "realSuperChapterId": 407,
            "selfVisible": 0,
            "shareDate": 1619711096000,
            "shareUser": "",
            "superChapterId": 408,
            "superChapterName": "公众号",
            "tags": [
        {
            "name": "公众号",
                "url": "/wxarticle/list/409/1"
        }
                ],
        "title": "&ldquo;by&rdquo; the way，探索Kotlin的委托机制",
            "type": 0,
            "userId": -1,
            "visible": 1,
            "zan": 0
    **/
    private int audit;
    private String author;
    private boolean canEdit;
    private int chapterId;
    private String chapterName;
    private boolean collect;
    private int courseId;
    private String desc;
    private String descMd;
    private String envelopePic;
    private boolean fresh;
    private String host;
    private int id;
    private String link;
    private String niceDate;
    private String niceShareDate;
    private String origin;
    private String prefix;
    private String projectLink;
    private long publishTime;
    private int realSuperChapterId;
    private int selfVisible;
    private long shareDate;
    private String shareUser;
    private int superChapterId;
    private String superChapterName;
    private String title;
    private int type;
    private int userId;
    private int visible;
    private int zan;
    private List<TagsBean> tags;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAudit() {
        return audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNiceDate() {
        return niceDate;
    }

    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }


    public static class TagsBean implements Serializable {
        /**
         * name : 公众号
         * url : /wxarticle/list/409/1
         */

        private String name1;
        private String url;
public TagsBean(String name1,String url){
    this.name1=name1;
    this.url=url;
}
        public String getName1() {
            return name1;
        }

        public void setName1(String name) {
            this.name1 = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
