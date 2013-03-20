package org.jonyframework.examples.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 地区信息实体类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-11
 * Time: 上午10:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="PEI_REGION")
public class Region extends IdEntity {
    /** 地区名称 */
    private String name;

    /** 上级地区ID */
    private int parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
