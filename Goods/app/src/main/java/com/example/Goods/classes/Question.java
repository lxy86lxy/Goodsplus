package com.example.Goods.classes;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {

    /**
     * apkLink :
     * audit : 1
     * author : xiaoyang
     * canEdit : false
     * chapterId : 440
     * chapterName : 官方
     * collect : false
     * courseId : 13
     * desc : <p>正常大家都清楚，当我们view发生一些必须要重新测量才能生效的属性的时候，我们会尝试触发view.requestLayout从而让整个view树发生重新测量与布局。</p>
     <p>今天的问题是:</p>
     <ol>
     <li>假设requestLayout的调用发生在灭屏/切home之后会立即触发吗？</li>
     <li>如果1不会立即触发，当我们回到应用，会自动重新触发一次requestLayout吗？</li>
     </ol>
     * descMd :
     * envelopePic :
     * fresh : false
     * host :
     * id : 17956
     * link : https://wanandroid.com/wenda/show/17956
     * niceDate : 2021-05-06 00:16
     * niceShareDate : 2021-04-15 14:40
     * origin :
     * prefix :
     * projectLink :
     * publishTime : 1620231413000
     * realSuperChapterId : 439
     * selfVisible : 0
     * shareDate : 1618468829000
     * shareUser :
     * superChapterId : 440
     * superChapterName : 问答
     * tags : [{"name":"本站发布","url":"/article/list/0?cid=440"},{"name":"问答","url":"/wenda"}]
     * title : 每日一问 | view.requestLayout如果在灭屏或者切home之后调用会怎么样？
     * type : 0
     * userId : 2
     * visible : 1
     * zan : 8
     */

    private String apkLink;
    private int audit;
    private String author;
    private boolean canEdit;
    private int chapterId;
    private String chapterName;

    public String getNiceDate() {
        return niceDate;
    }

    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }

    private boolean collect;
    private int courseId;
    private String desc;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String descMd;
    private String envelopePic;
    private boolean fresh;
    private String host;

    public int getAudit() {
        return audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }

    private int id;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

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
    public static class TagsBean implements Serializable {
        /**
         * name : 本站发布
         * url : /article/list/0?cid=440
         */

        private String name;
        private String url;
    }
}
