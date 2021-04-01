package com.it.springcloud.model.vo.student;

import com.it.springcloud.model.pojo.mybatis.mapper.entity.Students;
import lombok.Data;

import java.util.List;

@Data
public class StudentVo extends Students {
    private List<Integer> ids;

}
