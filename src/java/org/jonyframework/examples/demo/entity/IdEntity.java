package org.jonyframework.examples.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 统一定义ID的entity类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-10
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class IdEntity {
    protected Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
