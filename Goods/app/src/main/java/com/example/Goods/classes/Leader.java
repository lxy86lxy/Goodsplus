package com.example.Goods.classes;

import java.io.Serializable;
import java.util.List;
public class Leader implements Serializable {

    /**
     * apkLink :
     * audit : 1
     * author : miaowmiaow
     * canEdit : false
     * chapterId : 294
     * chapterName : 完整项目
     * collect : false
     * courseId : 13
     * desc : 采用 Kotlin 语言编写，单Activity多Fragment，MVVM + ViewModel + LiveData + Retrofit + 协程 + ViewBinding等架构设计的项目，项目结构清晰，代码简介优雅
     * descMd :
     * envelopePic : https://www.wanandroid.com/blogimgs/6d454437-1e59-4804-9f75-7255b0e816a9.png
     * fresh : false
     * host :
     * id : 18320
     * link : https://www.wanandroid.com/blog/show/3005
     * niceDate : 2021-05-16 23:08
     * niceShareDate : 2021-05-16 23:08
     * origin :
     * prefix :
     * projectLink : https://github.com/miaowmiaow/FragmentProject.git
     * publishTime : 1621177682000
     * realSuperChapterId : 293
     * selfVisible : 0
     * shareDate : 1621177682000
     * shareUser :
     * superChapterId : 294
     * superChapterName : 开源项目主Tab
     * tags : [{"name":"项目","url":"/project/list/1?cid=294"}]
     * title : 可能是东半球更简洁的玩安卓客户端
     * type : 0
     * userId : -1
     * visible : 1
     * zan : 0
     */

    private String apkLink;
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


//    public Leader(String author,String link,String niceDate,String title) {
//        this.link=link;
//        this.niceDate=niceDate;
//        this.author=author;
//        this.title=title;
//    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEnvelopePic() {
        return envelopePic;
    }

    public void setEnvelopePic(String envelopePic) {
        this.envelopePic = envelopePic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
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

    public static class TagsBean implements Serializable {
        /**
         * name : 项目
         * url : /project/list/1?cid=294
         */

        private String name;
        private String url;
    }
}
