package com.it.springcloud.common.exception.jsonException;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局统一处理控制器返回的JSON异常
 */
@RestControllerAdvice(annotations = RestController.class)
public class RestControllerExceptionHandler {


}
