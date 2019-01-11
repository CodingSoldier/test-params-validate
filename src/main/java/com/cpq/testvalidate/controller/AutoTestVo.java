package com.cpq.testvalidate.controller;

import com.cpq.testvalidate.bean.UserVo;
import com.github.codingsoldier.paramsvalidate.ParamsValidate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vo/auto/test")
public class AutoTestVo {

    @PostMapping("/post01")
    //@ParamsValidate(value = "/autotest/validate-file.json", key = "all01")
    public Object postMap(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVo vo) throws Exception{
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/testRequestFamily01")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "testRequestFamily01")
    public Object testRequestFamily01(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVo vo) throws Exception{
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/request01")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "testRequest01")
    public Object request01(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVo vo) throws Exception{
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/request02")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "testRequest2")
    public Object request02(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVo vo) throws Exception{
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/listRequestFalse01")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "listRequestFalse01")
    public Object listRequestFalse01(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVo vo) throws Exception{
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/goddessTest01")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "goddessTest01")
    public Object goddessTest01(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVo vo) throws Exception{
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/goddessBackupListRequestFalseTest01")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "goddessBackupListRequestFalseTest01")
    public Object goddessBackupListRequestFalseTest01(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVo vo) throws Exception{
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/goddessBackupListTwoRequestFalseTest02")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "goddessBackupListTwoRequestFalseTest02")
    public Object goddessBackupListTwoRequestFalseTest02(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVo vo) throws Exception{
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/baoBaoListTest01")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "baoBaoListTest01")
    public Object baoBaoListTest01(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVo vo) throws Exception{
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }


}
