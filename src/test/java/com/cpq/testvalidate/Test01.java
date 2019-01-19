package com.cpq.testvalidate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.text.NumberFormat;
import java.util.Map;
import java.util.regex.Pattern;

public class Test01 {

    @Test
    public void test1() throws Exception{
        File file = new File("E:\\workspace\\java-learn\\test-params-validate\\src\\test\\java\\com\\cpq\\testvalidate\\file.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        Object obj = mapper.readValue(file, Map.class);
        Map<String, Object> result = mapper.convertValue(obj, Map.class);
        //删除空值

    }

    @Test
    public void test2() throws Exception{
        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(nf.format(3.00));
        Pattern pattern = Pattern.compile("^(0|\\+?[1-9][0-9]*)$", Pattern.CASE_INSENSITIVE);
        System.out.println(pattern.matcher("0.0").matches());

    }

}











