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
    @ParamsValidate(file = "/learn-params-validate.json", key = "userValidate")
    public Object diningHallList(@RequestBody User user){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }
}
