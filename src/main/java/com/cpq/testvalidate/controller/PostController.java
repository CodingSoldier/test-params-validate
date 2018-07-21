package com.cpq.testvalidate.controller;

import com.cpq.testvalidate.bean.UserVo;
import com.github.codingsoldier.paramsvalidate.ParamsValidate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    @PostMapping("/p1/vo")
    //@ParamsValidate(file = "json-post.json")    //getParser()也要修改
    @ParamsValidate("json-post-gson.json")   //getParser()也要修改
    //@ParamsValidate(file = "json-post-fastjson.json")  //getParser()也要修改
    public Object p1(@RequestBody UserVo userVo, @RequestParam Map<String, Object> param) throws Exception{
        userVo.setValidateMessage("参数传递正确，校验成功");
        return userVo;
    }

    @RequestMapping("/form-data")
    @ParamsValidate(file = "json-post.json", keyName="jsonKeyFormData")
    public Object formData( @RequestParam("picFile") MultipartFile picFile, @RequestParam Map<String, Object> map) throws Exception {
        map.put("validateMessage", "参数传递正确，校验成功");
        return map;
    }

}
