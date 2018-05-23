package com.cpq.testvalidate.controller;

import com.cpq.testvalidate.bean.UserVo;
import com.github.codingsoldier.paramsvalidate.ParamsValidate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/get")
public class GetController {

    @RequestMapping("/attr")
    @ParamsValidate(file = "json-get.json")
    public Map<String, Object> attr(HttpServletRequest request,@ModelAttribute UserVo userVo) throws Exception {

        return new HashMap<String, Object>(){{put("r",userVo);}};
    }
}
