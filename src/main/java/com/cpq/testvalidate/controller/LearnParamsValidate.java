package com.cpq.testvalidate.controller;

import com.cpq.testvalidate.bean.User;
import com.github.codingsoldier.paramsvalidate.ParamsValidate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/learn")
public class LearnParamsValidate {

    @PostMapping("/demo1")
    /**
     * 添加校验注解@ParamsValidate
     * file的值是第三步中新建的json文件learn-params-validate.json
     * key的值是learn-params-validate.json中的userValidate
     */
    @ParamsValidate(file = "/learn-params-validate.json", key = "userValidate")
    public Object demo1(@RequestBody User user){
        System.out.println("demo1方法执行");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/demo2")
    @ParamsValidate(file = "/learn-params-validate.json", key = "userValidate02")
    public Object demo2(@RequestBody User user){
        System.out.println("demo2方法执行");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }
}
