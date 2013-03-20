package org.jonyframework.examples.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 品牌信息实体类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-11
 * Time: 下午4:20
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="PEI_BRAND")
public class Brand extends IdEntity {
    /** 品牌名称 */
    private String name;

    /** 品牌LOGO路径 */
    private String brandLogo;

    /** 品牌介绍 */
    private String brandDesc;

    /** 品牌网站 */
    private String brandSite;

    /** 添加时间 */
    private Date createdAt;

    /** 更新时间 */
    private Date updatedAt;
}
