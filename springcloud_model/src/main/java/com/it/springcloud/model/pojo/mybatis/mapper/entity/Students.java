package com.it.springcloud.model.pojo.mybatis.mapper.entity;

import java.io.Serializable;

public class Students implements Serializable {
    private Integer id;

    private Integer sno;

    private String sname;

    private Short age;

    private String sex;

    private String bplace;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBplace() {
        return bplace;
    }

    public void setBplace(String bplace) {
        this.bplace = bplace;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sno=").append(sno);
        sb.append(", sname=").append(sname);
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
        sb.append(", bplace=").append(bplace);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}