package com.xin.menu.entity;



import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Menu{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String menuname;
    private Integer authorid;
    private String jsonpath;
    private String imgpath;
    private Integer isad;
    private String authorname;

    public List<Tag> getTaginfo() {
        return taginfo;
    }

    public void setTaginfo(List<Tag> taginfo) {
        this.taginfo = taginfo;
    }
    public void addTaginfo(Tag info){
        this.taginfo.add(info);
    }

    @Transient
    private List<Tag> taginfo = new ArrayList<>();

    public Menu(){ }

    public Menu(Integer id, String menuname, Integer authorid, String imgpath,String authorname){
        this.id = id;
        this.menuname = menuname;
        this.authorid = authorid;
        this.imgpath = imgpath;
        this.authorname = authorname;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getJsonpath() {
        return jsonpath;
    }

    public void setJsonpath(String jsonpath) {
        this.jsonpath = jsonpath;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public Integer getIsad() {
        return isad;
    }

    public void setIsad(Integer isad) {
        this.isad = isad;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuname='" + menuname + '\'' +
                ", authorid=" + authorid +
                ", jsonpath='" + jsonpath + '\'' +
                ", imgpath='" + imgpath + '\'' +
                ", isad=" + isad +
                ", authorname='" + authorname + '\'' +
                '}';
    }
}
