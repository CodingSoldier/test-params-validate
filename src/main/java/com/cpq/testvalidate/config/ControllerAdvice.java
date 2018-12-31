package com.cpq.testvalidate.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

// 全局异常处理器
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 100000);
        map.put("msg", ex.getMessage());
        LOGGER.error("Exception",ex);
        return map;
    }

}
