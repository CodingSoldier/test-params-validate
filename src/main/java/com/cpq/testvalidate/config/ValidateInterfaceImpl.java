package com.cpq.testvalidate.config;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.github.codingsoldier.paramsvalidate.PvUtil;
import com.github.codingsoldier.paramsvalidate.ValidateInterfaceAdapter;
import com.github.codingsoldier.paramsvalidate.bean.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ValidateInterfaceImpl extends ValidateInterfaceAdapter implements  InitializingBean {

    //redis
    @Autowired
    RedisTemplate redisTemplate;

    //返回json文件基础路径。init.json文件必须放在此目录下，默认是resources/validate
    //@Override
    //public String basePath() {
    //    return "/validate/";
    //}

    /**
     * 校验级别
     * PvLevel.STRICT  严格模式，@ParamsValidate发生异常，校验不通过，默认
     * PvLevel.LOOSE   宽松模式，@ParamsValidate发生异常，不校验
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

    /**
     * 参数校验未通过, 返回自定义数据给客户端的数据
     * 我覆盖此方法，仅仅是为了方便自动化测试。
     * 此方法的代码和父类ValidateInterfaceAdapter的validateNotPass()代码几乎一样
     */
    @Override
    public Object validateNotPass(ResultValidate resultValidate) {
        List<Map<String, String>> msgList = resultValidate.getMsgList();
        /**
         * 父类ValidateInterfaceAdapter是new HashMap<>()
         * 我new TreeMap<>()是为了让返回结果有序，方便自动化测试
         */
        Map<String, String> data = new TreeMap<>();
        for (Map<String, String> elemMap:msgList){
            if (elemMap != null){
                Boolean requestVal = Boolean.parseBoolean(elemMap.get(PvMsg.REQUEST));
                String minVal = elemMap.get(PvMsg.MIN_VALUE);
                String maxVal = elemMap.get(PvMsg.MAX_VALUE);
                String minLen = elemMap.get(PvMsg.MIN_LENGTH);
                String maxLen = elemMap.get(PvMsg.MAX_LENGTH);
                String jsonMsg = elemMap.get(PvMsg.MESSAGE);

                String message = "";
                message = PvUtil.isNotBlankObj(jsonMsg) ? (message+jsonMsg+"，") : message;
                message = Boolean.TRUE.equals(requestVal) ? (message+"必填，") : message;
                message = PvUtil.isNotBlankObj(minVal) ? (message+"最小值"+minVal+"，") : message;
                message = PvUtil.isNotBlankObj(maxVal) ? (message+"最大值"+maxVal+"，") : message;
                message = PvUtil.isNotBlankObj(minLen) ? (message+"最小长度"+minLen+"，") : message;
                message = PvUtil.isNotBlankObj(maxLen) ? (message+"最大长度"+maxLen+"，") : message;
                message = "".equals(message) ? "未通过校验，" : message;
                message = message.substring(0, message.length()-1);

                String name = elemMap.get(PvMsg.NAME);
                data.put(name, message);
            }
        }
        Map<String, Object> r = new HashMap<>();
        r.put("code", resultValidate.isPass() ? 0 : 101);
        r.put("data", data);
        return r;
    }

    /**
     * 不使用缓存，可不覆盖此方法
     * 获取redis缓存中的校验规则
     */
    @Override
    public Map<String, Object> getCache(ValidateConfig validateConfig) {
        String key = createKey(validateConfig);
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 不使用缓存，可不覆盖此方法
     * 设置redis校验规则到缓存中
     */
    @Override
    public void setCache(ValidateConfig validateConfig, Map<String, Object> json) {
        String key = createKey(validateConfig);
        redisTemplate.opsForHash().putAll(key, json);
    }


    //创建缓存key
    private String createKey(ValidateConfig validateConfig){
        String basePath = PvUtil.trimBeginEndChar(basePath(), '/') + "/";
        String fileName = validateConfig.getFile().substring(0, validateConfig.getFile().lastIndexOf(".json"));
        fileName = PvUtil.trimBeginEndChar(fileName, '/');
        String jsonKey = validateConfig.getKey();
        jsonKey = PvUtil.isBlank(jsonKey) ? jsonKey : (":"+jsonKey);
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
