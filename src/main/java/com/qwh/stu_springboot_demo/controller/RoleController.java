package com.qwh.stu_springboot_demo.controller;

import com.qwh.stu_springboot_demo.domain.Role;
import com.qwh.stu_springboot_demo.domain.User;
import com.qwh.stu_springboot_demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/insert/{id}/{role_name}/{user_id}")
    public  Object insert(@PathVariable int id,@PathVariable String role_name,@PathVariable int user_id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Role role=new Role();
        role.setId(id);
        role.setRole_name(role_name);
        role.setUser_id(user_id);
        int count=roleService.insert(role);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @RequestMapping("/select/{id}")
    public  Object select(@PathVariable int id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Role role=new Role();
        role=roleService.select(id);
        result.put("data", role);
        return result;
    }

    @RequestMapping("/update/{id}/{role_name}")
    public  Object update(@PathVariable int id,@PathVariable String role_name){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Role role=new Role();
        role.setId(id);
        role.setRole_name(role_name);
        //role.setUser_id(user_id);
        int count=roleService.update(role);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @RequestMapping("/delete/{id}")
    public  Object delete(@PathVariable int id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        int count=roleService.delete(id);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @RequestMapping("/getRoleByUserName/{name}")
    public  Object getRoleByUserName(@PathVariable String name){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        List<Role> data=roleService.getRoleByUserName(name);
        if(data.size()>0){
            result.put("data", data);
        }else{
            result.put("data","没有找到");
        }

        return result;
    }
}
