package com.cpq.testvalidate.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.github.codingsoldier.paramsvalidate.ValidateInterfaceAdapter;
import com.github.codingsoldier.paramsvalidate.ValidateUtils;
import com.github.codingsoldier.paramsvalidate.bean.Parser;
import com.github.codingsoldier.paramsvalidate.bean.ValidateConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ValidateInterfaceImpl extends ValidateInterfaceAdapter implements  InitializingBean {

    //存
    @Autowired
    RedisTemplate redisTemplate;

    //返回json文件基础路径。init.json文件必须放在此目录下
    @Override
    public String basePath() {
        return "config/validate/";
    }

    /**
     * 校验级别
     * PvLevel.STRICT  严格模式，发生异常，校验不通过，默认
     * PvLevel.LOOSE   宽松模式，发生异常，不校验
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
        //return new Parser(Gson.class);
        return new Parser(JSON.class, Feature[].class);
    }

    //参数校验未通过, 返回自定义数据给客户端的数据
    //@Override
    //public Object validateNotPass(ResultValidate resultValidate) {
    //
    //};

    /**
     * 不使用缓存，可不覆盖此方法
     * 获取redis缓存中的校验规则
     */
    //@Override
    //public Map<String, Object> getCache(ValidateConfig validateConfig) {
    //    String key = createKey(validateConfig);
    //    return redisTemplate.opsForHash().entries(key);
    //}

    /**
     * 不使用缓存，可不覆盖此方法
     * 设置redis校验规则到缓存中
     */
    //@Override
    //public void setCache(ValidateConfig validateConfig, Map<String, Object> json) {
    //    String key = createKey(validateConfig);
    //    redisTemplate.opsForHash().putAll(key, json);
    //}


    //创建缓存key
    private String createKey(ValidateConfig validateConfig){
        String basePath = ValidateUtils.trimBeginEndChar(basePath(), '/') + "/";
        String fileName = validateConfig.getFile().substring(0, validateConfig.getFile().lastIndexOf(".json"));
        fileName = ValidateUtils.trimBeginEndChar(fileName, '/');
        String jsonKey = validateConfig.getKey();
        jsonKey = ValidateUtils.isBlank(jsonKey) ? jsonKey : (":"+jsonKey);
        String temp = basePath + fileName + jsonKey;
        return temp.replaceAll("[\\/\\-]",":");
    }

    //项目启动时，删除redis缓存校验规则
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


}
