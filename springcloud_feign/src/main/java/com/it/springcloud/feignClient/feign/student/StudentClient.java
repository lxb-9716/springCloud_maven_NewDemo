package com.it.springcloud.feignClient.feign.student;

import com.it.springcloud.api.student.StudentApi;
import com.it.springcloud.feignClient.hystrix.student.StudentCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;


@Component
@FeignClient(name = "spring-cloud-swagger-data-server", fallback = StudentCallBack.class)
public interface StudentClient extends StudentApi {

}
