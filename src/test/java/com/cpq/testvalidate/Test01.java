package com.cpq.testvalidate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.codingsoldier.paramsvalidate.PvUtil;
import org.junit.Test;

import java.io.File;
import java.util.Map;

public class Test01 {

    @Test
    public void test1() throws Exception{
        File file = new File("E:\\workspace\\java-learn\\test-params-validate\\src\\test\\java\\com\\cpq\\testvalidate\\file.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        Object obj = mapper.readValue(file, Map.class);
        Map<String, Object> result = mapper.convertValue(obj, Map.class);
        //删除空值
        PvUtil.deleteMapEmptyValue(result);
        boolean isEmpty = PvUtil.isDepthValueEmpty(result);
        System.out.println(isEmpty);
    }

    @Test
    public void test2() throws Exception{
        Double.parseDouble(null);
    }


}











