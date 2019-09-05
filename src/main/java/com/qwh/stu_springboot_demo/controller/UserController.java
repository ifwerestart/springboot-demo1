package com.qwh.stu_springboot_demo.controller;

import com.qwh.stu_springboot_demo.domain.User;
import com.qwh.stu_springboot_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/insert/{name}/{password}/{sal}")
    public  Object insert(@PathVariable String name, @PathVariable String password,@PathVariable double sal){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setSal(sal);
        int count=userService.insertUser(user);
        if (count > 0)
            result.put("code", 0);
        return result;
        //return "name= "+name+"  password= "+password;
    }

    @RequestMapping(value="/insertSelective/{name}/{sal}")
    public  Object insertSelective(@PathVariable String name, @PathVariable double sal){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        User user=new User();
        user.setName(name);
        user.setSal(sal);
        int count=userService.insertSelective(user);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @RequestMapping(value="/update/{id}/{name}/{password}")
    public  Object update(@PathVariable int id,@PathVariable String name, @PathVariable String password){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setId(id);
        int count=userService.updateSelective(user);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @RequestMapping(value="/select/{id}")
    public  Object select(@PathVariable int id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        result.put("data",userService.findUser(id));

        //System.out.print(u.getName());
        return result;
    }

    @RequestMapping(value="/findAll")
    public  Object findAll(){
        List<User> user=userService.findAll();
        if(user.size()>0){
            return "第一个name= "+user.get(0).getName()+"  password= "+user.get(0).getPassword();
        }else{
            return "没有用户";
        }

    }

    @RequestMapping(value="/delete/{id}")
    public  Object delete(@PathVariable int id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        User user=new User();
        int count=userService.deleteUser(id);
        if (count > 0)
            result.put("code", 0);
        return result;
    }


}
