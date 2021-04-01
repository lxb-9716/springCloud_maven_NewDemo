package com.it.springcloud.model.pojo.mybatis.mapper.entity;

import java.io.Serializable;

public class TeaCouClass implements Serializable {
    private Integer id;

    private Short tno;

    private String cno;

    private String classname;

    private Integer snum;

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

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tno=").append(tno);
        sb.append(", cno=").append(cno);
        sb.append(", classname=").append(classname);
        sb.append(", snum=").append(snum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}