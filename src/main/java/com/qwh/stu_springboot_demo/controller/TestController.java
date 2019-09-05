package com.qwh.stu_springboot_demo.controller;


import com.qwh.stu_springboot_demo.config.jedis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class TestController {
    @RequestMapping("/test")
    public  Object test1(){
        return "hello world";
    }

    @RequestMapping(value="/rest/test2/{param}/{age}")
    public  Object restTest(@PathVariable(value="param") String name,@PathVariable String age){
       return "this is  name= "+name+"  age= "+age;
    }

    @Autowired
    private JedisUtil jedis;
    @RequestMapping("/restJedis/{val}")
    public  Object restJedis(@PathVariable String val){
        jedis.set("key-"+val,val);
        return  "restJedis_Ok";
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/getJDBC/{id}")
    public Object getJDBC(@PathVariable Integer id){
        String sql="select * from user where id="+id;
        Map<String,Object> data=jdbcTemplate.queryForMap(sql);
        return data;
    }


}
