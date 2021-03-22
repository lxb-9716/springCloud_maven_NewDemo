package com.it.springcloud.swagger.repository.logRepository;

import com.it.springcloud.model.pojo.mongodb.LogBean;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogBean, String> {

}
