package org.jonyframework.examples.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * 食材信息实体类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-11
 * Time: 上午11:34
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="PEI_COOK_MATERIAL")
public class CookMaterial extends IdEntity {
    /** 食材名称 */
    private String name;

    /** 食材介绍 */
    private String intro;

    /** 食材简介缩略图片 */
    private String intro_thumb;

    /** 食材简介图片 */
    private String intro_img;

    /** 库存数量 */
    private Double materialNumber;

    /** 报警数量 */
    private Integer warnNumber;

    /** 计价单位 */
    private String materialUnit;

    /** 市场定价 */
    private Double marketPrice;

    /** 品牌ID */
    private Integer brandId;

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

    public Double getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(Double materialNumber) {
        this.materialNumber = materialNumber;
    }

    public Integer getWarnNumber() {
        return warnNumber;
    }

    public void setWarnNumber(Integer warnNumber) {
        this.warnNumber = warnNumber;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
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
