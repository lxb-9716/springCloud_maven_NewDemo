package com.it.springcloud.swagger.repository.mongoLog;

import com.it.springcloud.model.pojo.jpa.mongodb.LogBean;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogBean, String> {

}
