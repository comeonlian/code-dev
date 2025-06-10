package com.leolian.exceltodb.entity;

import java.util.Date;

/**
 * @author Administrator
 * @description:
 * @date 2025/6/5 20:31
 */
public class UserMessage {
    private int id;
    private String companyName; //公司名称
    private String personName; //名字
    private String position; //职位
    private String profession; //行业
    private long contact; //手机号
    private int contactStatus; //手机号状态
    private String qqNumber; //QQ号
    private String email; //邮箱
    private String address; //地址
    private String registerCapital; //注册资本
    private Date registerDate; //注册日期
    private String queryCondition; //查询条件
    private String remark; //备注
    private Date createDate; //记录时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public int getContactStatus() {
        return contactStatus;
    }

    public void setContactStatus(int contactStatus) {
        this.contactStatus = contactStatus;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(String registerCapital) {
        this.registerCapital = registerCapital;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getQueryCondition() {
        return queryCondition;
    }

    public void setQueryCondition(String queryCondition) {
        this.queryCondition = queryCondition;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "companyName='" + companyName + '\'' +
                ", personName='" + personName + '\'' +
                ", profession='" + profession + '\'' +
                ", contact=" + contact +
                ", contactStatus=" + contactStatus +
                '}';
    }
}
