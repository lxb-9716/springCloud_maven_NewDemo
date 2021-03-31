package com.it.springcloud.model.pojo.mybatis.mapper.entity;

import java.io.Serializable;

public class Teachers implements Serializable {
    private Integer id;

    private Short tno;

    private String tname;

    private Short age;

    private String ps;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getTno() {
        return tno;
    }

    public void setTno(Short tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tno=").append(tno);
        sb.append(", tname=").append(tname);
        sb.append(", age=").append(age);
        sb.append(", ps=").append(ps);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}