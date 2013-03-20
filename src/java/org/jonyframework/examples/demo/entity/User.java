package org.jonyframework.examples.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.List;

/**
 * 用户Entity类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-10
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="pei_user")
public class User extends IdEntity {
    /** 登录账号 */
    private String loginName;

    /** email地址 */
    private String email;

    /** 性别 */
    private int sex;

    /** 密码 */
    private String password;

    /** 密码salt */
    private String salt;

    /** 用户昵称 */
    private String nickName;

    /** 注册时间 */
    private Date createdAt;

    /** 更新时间 */
    private Date updatedAt;

    /** 用户上次登录IP地址 */
    private String lastLoginIp;

    /** 用户上次登录时间 */
    private Date lastLoginTime;

    /** 用户出生日期 */
    private Date birthday;

    /** 确认密码 */
    private String plainPassword;

    /** 用户所属角色 */
    private String roles;

    public String getRoles() {
        return this.roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    @Transient
    @JsonIgnore
    public String getPlainPassword() {
        return this.plainPassword;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    @Transient
    @JsonIgnore
    public List<String> getRoleList() {
        // 角色列表在数据库中实际以逗号分隔字符串存储，因此返回不能修改的List.
        return ImmutableList.copyOf(StringUtils.split(roles, ","));
    }
}
