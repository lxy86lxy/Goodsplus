package com.example.Goods.classes;

import java.io.Serializable;
import java.util.List;
public class Struct implements Serializable {

    /**
     * children : []
     * courseId : 13
     * id : 60
     * name : Android Studio相关
     * order : 1000
     * parentChapterId : 150
     * userControlSetTop : false
     * visible : 1
     */

    private int courseId;
    private int id;
    private List<Integer> idList;
    private String name;
    private List<String> nameList;
    private int order;
    private int parentChapterId;
    private boolean userControlSetTop;
    private int visible;
    private List<?> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}
