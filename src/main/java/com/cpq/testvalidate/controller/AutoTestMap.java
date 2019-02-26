package com.cpq.testvalidate.controller;

import com.github.codingsoldier.paramsvalidate.ParamsValidate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    @PostMapping("/goddessListFalseTest")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "goddessListFalse")
    public Object goddessListFalseTest(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/dreamListtest")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "dreamList")
    public Object dreamListtest(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/dreamListTest02")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "dreamListTest02")
    public Object dreamListTest02(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/dreamListTest021")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "dreamListTest021")
    public Object dreamListTest021(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/dreamListTest022")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "dreamListTest022")
    public Object dreamListTest022(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/dreamListTest03")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "dreamListTest03")
    public Object dreamListTest03(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/baoBaoList")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "baoBaoList")
    public Object baoBaoList(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/baoBaoListRequest")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "baoBaoListRequest")
    public Object baoBaoListRequest(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/baoBaoListRequest02")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "baoBaoListRequest02")
    public Object baoBaoListRequest02(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/all01")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "all01")
    public Object all01(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

    @PostMapping("/requestElem")
    @ParamsValidate(value = "/autotest/validate-file.json", key = "requestElem")
    public Object requestElem(@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = new HashMap<>();
        map1.put("code", 0);
        map1.put("data", "成功");
        return map1;
    }

}
