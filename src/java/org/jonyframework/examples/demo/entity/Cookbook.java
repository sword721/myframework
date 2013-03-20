package org.jonyframework.examples.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 食谱信息实体类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-11
 * Time: 上午10:34
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="PEI_COOKBOOK")
public class Cookbook extends IdEntity{
    /** 食谱名称 */
    private String name;

    /** 食谱介绍 */
    private String intro;

    /** 食谱缩略图片 */
    private String intro_thumb;

    /** 食谱介绍图片 */
    private String intro_img;

    /** 烹饪说明 */
    private String cookeryBook;

    /** 创建时间 */
    private Date createdAt;

    /** 更新时间 */
    private Date updatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIntro_thumb() {
        return intro_thumb;
    }

    public void setIntro_thumb(String intro_thumb) {
        this.intro_thumb = intro_thumb;
    }

    public String getIntro_img() {
        return intro_img;
    }

    public void setIntro_img(String intro_img) {
        this.intro_img = intro_img;
    }

    public String getCookeryBook() {
        return cookeryBook;
    }

    public void setCookeryBook(String cookeryBook) {
        this.cookeryBook = cookeryBook;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
