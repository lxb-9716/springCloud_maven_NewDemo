package com.it.springcloud.model.pojo.mybatis.mapper.entity.extend;

import com.it.springcloud.model.pojo.mybatis.mapper.entity.Courses;
import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class StudentsExtend extends Students {
    private List<CoursesExtend> coursesExtends;
}
