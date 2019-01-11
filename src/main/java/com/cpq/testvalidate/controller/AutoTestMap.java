package com.cpq.testvalidate.controller;

import com.github.codingsoldier.paramsvalidate.ParamsValidate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auto/test")
public class AutoTestMap {

    @PostMapping("/hobbyList")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "hobbyList")
    public Object hobbyList(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/hobbyListTest01")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "hobbyListTest01")
    public Object hobbyListTest01(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/schoolClassList")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "schoolClassList")
    public Object schoolClassList(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/schoolClassListTest01")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "schoolClassListTest01")
    public Object schoolClassListTest01(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/diningHallList")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "diningHallList")
    public Object diningHallList(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/diningHallListRequestFalse")
    @ParamsValidate(file = "/autotest/validate-file.json", key = "diningHallListRequestFalse")
    public Object diningHallListRequestFalse(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/family")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "family")
    public Object family(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/goddesstest")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "goddess")
    public Object goddess(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }
















    //@PostMapping("/post01")
    ////@ParamsValidate(value = "/autotest/validate-file.json", key = "all01")
    //public Object postMap(@RequestBody Map<String, Object> map){
    //    Map<String, Object> map1 = new HashMap<>();
    //    map1.put("code", 0);
    //    map1.put("data", "成功");
    //    return map1;
    //}
    //

    //
    //@PostMapping("/request01")
    //@ParamsValidate(value = "/autotest/validate-file.json", key = "testRequest01")
    //public Object request01(@RequestBody Map<String, Object> map){
    //    Map<String, Object> map1 = new HashMap<>();
    //    map1.put("code", 0);
    //    map1.put("data", "成功");
    //    return map1;
    //}
    //
    //@PostMapping("/request02")
    //@ParamsValidate(file = "/autotest/validate-file.json", key = "testRequest2")
    //public Object request02(@RequestBody Map<String, Object> map){
    //    Map<String, Object> map1 = new HashMap<>();
    //    map1.put("code", 0);
    //    map1.put("data", "成功");
    //    return map1;
    //}
    //
    //@PostMapping("/listRequestFalse01")
    //@ParamsValidate(file = "/autotest/validate-file.json", key = "listRequestFalse01")
    //public Object listRequestFalse01(@RequestBody Map<String, Object> map){
    //    Map<String, Object> map1 = new HashMap<>();
    //    map1.put("code", 0);
    //    map1.put("data", "成功");
    //    return map1;
    //}
    //
    //@PostMapping("/goddessTest01")
    //@ParamsValidate(file = "/autotest/validate-file.json", key = "goddessTest01")
    //public Object goddessTest01(@RequestBody Map<String, Object> map){
    //    Map<String, Object> map1 = new HashMap<>();
    //    map1.put("code", 0);
    //    map1.put("data", "成功");
    //    return map1;
    //}
    //
    //@PostMapping("/goddessBackupListRequestFalseTest01")
    //@ParamsValidate(file = "/autotest/validate-file.json", key = "goddessBackupListRequestFalseTest01")
    //public Object goddessBackupListRequestFalseTest01(@RequestBody Map<String, Object> map){
    //    Map<String, Object> map1 = new HashMap<>();
    //    map1.put("code", 0);
    //    map1.put("data", "成功");
    //    return map1;
    //}
    //
    //@PostMapping("/goddessBackupListTwoRequestFalseTest02")
    //@ParamsValidate(file = "/autotest/validate-file.json", key = "goddessBackupListTwoRequestFalseTest02")
    //public Object goddessBackupListTwoRequestFalseTest02(@RequestBody Map<String, Object> map){
    //    Map<String, Object> map1 = new HashMap<>();
    //    map1.put("code", 0);
    //    map1.put("data", "成功");
    //    return map1;
    //}
    //
    //@PostMapping("/baoBaoListTest01")
    //@ParamsValidate(file = "/autotest/validate-file.json", key = "baoBaoListTest01")
    //public Object baoBaoListTest01(@RequestBody Map<String, Object> map){
    //    Map<String, Object> map1 = new HashMap<>();
    //    map1.put("code", 0);
    //    map1.put("data", "成功");
    //    return map1;
    //}
    //
    //@PostMapping("/hobbyListTest01")
    //@ParamsValidate(file = "/autotest/validate-file.json", key = "hobbyListTest01")
    //public Object hobbyListTest01(@RequestBody Map<String, Object> map){
    //    Map<String, Object> map1 = new HashMap<>();
    //    map1.put("code", 0);
    //    map1.put("data", "成功");
    //    return map1;
    //}






}
