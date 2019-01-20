package com.cpq.testvalidate.config;


import com.github.codingsoldier.paramsvalidate.PvUtil;
import com.github.codingsoldier.paramsvalidate.ValidateInterfaceAdapter;
import com.github.codingsoldier.paramsvalidate.bean.Parser;
import com.github.codingsoldier.paramsvalidate.bean.PvConst;
import com.github.codingsoldier.paramsvalidate.bean.ResultValidate;
import com.github.codingsoldier.paramsvalidate.bean.ValidateConfig;
import com.google.gson.Gson;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ValidateInterfaceImpl extends ValidateInterfaceAdapter implements InitializingBean {
    @Autowired
    RedisTemplate redisTemplate;

    //类属性初始化后，删除redis缓存校验规则
    @Override
    public void afterPropertiesSet() throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(1);
        es.execute(new Runnable() {
            @Override
            public void run() {
                Set<String> keys = redisTemplate.keys(basePath().replace("/",":") + "*");
                redisTemplate.delete(keys);
            }
        });
        es.shutdown();
    }

    //redis

    //返回json文件基础路径。init.json文件必须放在此目录下，默认是resources/validate
    //@Override
    //public String basePath() {
    //    return "/validate/";
    //}

    /**
     * 校验级别
     * PvConst.LEVEL_STRICT  严格模式，发生异常，校验不通过，默认
     * PvConst.LEVEL_LOOSE   宽松模式，发生异常，不校验
     */
    //@Override
    //public String getLevel(){
    //    return PvLevel.LOOSE;
    //}

    /**
     * json解析器
     * 1、使用默认解析器jackson，可不覆盖此方法
     * 2、使用gson，请返回 new Parser(Gson.class);
     * 3、使用fastjson，请返回new Parser(JSON.class, Feature[].class)
     * 为了支持fastjson，搞得好坑爹
     */
    public Parser getParser(){
        return new Parser(Gson.class);
        //return new Parser(JSON.class, Feature[].class);
    }

    /**
     * 参数校验未通过, 返回自定义数据给客户端的数据
     * 我覆盖此方法，仅仅是为了方便自动化测试。
     */
    @Override
    public Object validateNotPass(ResultValidate resultValidate) {
        List<Map<String, String>> msgList = resultValidate.getMsgList();
        Map<String, String> data = new TreeMap<>();
        for (Map<String, String> elemMap:msgList){
            if (elemMap != null){
                Boolean requestVal = Boolean.parseBoolean(elemMap.get(PvConst.REQUEST));
                String minVal = elemMap.get(PvConst.MIN_VALUE);
                String maxVal = elemMap.get(PvConst.MAX_VALUE);
                String minLen = elemMap.get(PvConst.MIN_LENGTH);
                String maxLen = elemMap.get(PvConst.MAX_LENGTH);
                String jsonMsg = elemMap.get(PvConst.MESSAGE);

                String message = "";
                message = PvUtil.isNotBlankObj(jsonMsg) ? (message+jsonMsg+"，") : message;
                message = Boolean.TRUE.equals(requestVal) ? (message+"必填，") : message;
                if (PvUtil.isNotBlankObj(minVal)){
                    minVal = minVal.replaceAll("0+?$", "");
                    minVal = minVal.replaceAll("[.]$", "");
                    message = message+"最小值"+minVal+"，";
                }
                if (PvUtil.isNotBlankObj(maxVal)){
                    maxVal = maxVal.replaceAll("0+?$", "");
                    maxVal = maxVal.replaceAll("[.]$", "");
                    message = message+"最大值"+maxVal+"，";
                }
                message = PvUtil.isNotBlankObj(minLen) ? (message+"最小长度"+Float.valueOf(minLen).intValue()+"，") : message;
                message = PvUtil.isNotBlankObj(maxLen) ? (message+"最大长度"+Float.valueOf(maxLen).intValue()+"，") : message;
                message = "".equals(message) ? "未通过校验，" : message;
                message = message.substring(0, message.length()-1);

                String name = elemMap.get(PvConst.NAME);
                data.put(name, message);
            }
        }
        Map<String, Object> r = new HashMap<>();
        r.put("code", resultValidate.isPass() ? 0 : 101);
        r.put("data", data);
        return r;
    }


    /**
     * ValidateConfig这个对象储存@ParamsValidate注解的值
     * 获取@ParamsValidate中的key在redis中的校验规则
     */
    @Override
    public Map<String, Object> getKeyCache(ValidateConfig validateConfig) {
        String redisKey = createRedisKey(validateConfig);
        return (Map<String, Object>)redisTemplate.opsForHash().get(redisKey, validateConfig.getKey());
    }

    /**
     * 将整个json文件的内容存储为hash结构
     */
    @Override
    public void setFileCache(ValidateConfig validateConfig, Map<String, Map<String, Object>> json) {
        String redisKey = createRedisKey(validateConfig);
        redisTemplate.opsForHash().putAll(redisKey, json);
    }

    /**
     * 使用basePath()返回的目录名+@ParamsValidate的file文件名作为redis的key
     */
    private String createRedisKey(ValidateConfig validateConfig){
        String basePath = PvUtil.trimBeginEndChar(basePath(), '/') + "/";
        String fileName = validateConfig.getFile().substring(0, validateConfig.getFile().lastIndexOf(".json"));
        fileName = PvUtil.trimBeginEndChar(fileName, '/');
        String temp = basePath + fileName;
        return temp.replaceAll("[\\/\\-]",":");
    }


    ////项目启动时，删除redis缓存校验规则
    //@Override
    //public void afterPropertiesSet() throws Exception {
    //    ExecutorService es = Executors.newFixedThreadPool(1);
    //    es.execute(new Runnable() {
    //        @Override
    //        public void run() {
    //            Set<String> keys = redisTemplate.keys(basePath().replace("/",":") + "*");
    //            redisTemplate.delete(keys);
    //        }
    //    });
    //    es.shutdown();
    //}

}

