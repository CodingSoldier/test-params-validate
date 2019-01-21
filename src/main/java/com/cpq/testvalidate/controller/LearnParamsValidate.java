package com.cpq.testvalidate.controller;

import com.cpq.testvalidate.bean.Cate;
import com.cpq.testvalidate.bean.House;
import com.cpq.testvalidate.bean.User;
import com.github.codingsoldier.paramsvalidate.ParamsValidate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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

    @PostMapping("/userValidateInit")
    @ParamsValidate(file = "/learn-params-validate.json", key = "userValidateInit")
    public Object userValidateInit(@RequestBody User user){
        System.out.println("userValidateInit方法执行");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/house")
    @ParamsValidate(file = "/learn-params-validate.json", key = "house")
    public Object house(@RequestBody House house){
        System.out.println("house方法执行");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/hobbyList")
    @ParamsValidate(file = "/learn-params-validate.json", key = "hobbyList")
    public Object hobbyList(@RequestBody Map<String, List<String>> param){
        System.out.println("hobbyList方法执行");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/cateList")
    @ParamsValidate(file = "/learn-params-validate.json", key = "param")
    public Object cateList(@RequestBody Map<String, List<Cate>> param){
        System.out.println("cateList方法执行");
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }


}
