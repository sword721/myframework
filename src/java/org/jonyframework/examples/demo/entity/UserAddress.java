package org.jonyframework.examples.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户收货信息实体类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-11
 * Time: 上午9:31
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="PEI_USER_ADRESS")
public class UserAddress extends IdEntity {
    /** 收货信息名称 */
    private String addressName;

    /** 收货人名称 */
    private String consignee;

    /** 收货人国家 */
    private int country;

    /** 收货人所在省份 */
    private int province;

    /** 收货人所在城市 */
    private int city;

    /** 收货人所在地区 */
    private int district;

    /** 收货人详细地址 */
    private String address;

    /** 邮政编码 */
    private String zipcode;

    /** 电话号码 */
    private String tel;

    /** 手机号码 */
    private String mobile;

    /** 是否作为默认收货信息 */
    private int isDefault;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getDefault() {
        return isDefault;
    }

    public void setDefault(int aDefault) {
        isDefault = aDefault;
    }
}
