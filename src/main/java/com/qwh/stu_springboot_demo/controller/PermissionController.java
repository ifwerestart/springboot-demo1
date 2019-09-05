package com.qwh.stu_springboot_demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qwh.stu_springboot_demo.domain.Permission;
import com.qwh.stu_springboot_demo.domain.Role;
import com.qwh.stu_springboot_demo.service.PermissionService;
import com.qwh.stu_springboot_demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/insert/{id}/{permission}/{role_id}")
    public  Object insert(@PathVariable int id, @PathVariable String permission, @PathVariable int role_id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Permission permission1=new Permission();
        permission1.setId(id);
        permission1.setPermission(permission);
        permission1.setRole_id(role_id);
        int count=permissionService.insert(permission1);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @RequestMapping("/insert1/{param}")
    public  Object insert1(@PathVariable String param) throws Exception{
        //jsckson获取json数据
        ObjectMapper om = new ObjectMapper();
        //把json字符串转成实体类
        Permission readValue = om.readValue(param,Permission.class);
        int count=permissionService.insert(readValue);

        //把实体类转成字符串
        String ex_json=om.writeValueAsString(readValue);
        //把json字符串转成json格式
        JsonNode rootNode=om.readValue(param, JsonNode.class);
        int id=rootNode.get("id").asInt();
        String per=rootNode.get("permission").asText();
        int role_id=rootNode.get("role_id").asInt();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Permission permission1=new Permission();
        permission1.setId(id);
        permission1.setPermission(per);
        permission1.setRole_id(role_id);

        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @RequestMapping("/select/{id}")
    public  Object select(@PathVariable int id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Permission permission1=new Permission();
        permission1=permissionService.select(id);
        result.put("data", permission1);
        return result;
    }

    @RequestMapping("/update/{id}/{permission}")
    public  Object update(@PathVariable int id,@PathVariable String permission){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Permission permission1=new Permission();
        permission1.setPermission(permission);
        permission1.setId(id);

        int count=permissionService.update(permission1);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @RequestMapping("/delete/{id}")
    public  Object delete(@PathVariable int id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        int count=permissionService.delete(id);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @RequestMapping("/getPermissionByRoleId/{role_id}")
    public  Object getRoleByUserName(@PathVariable int role_id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        List<Permission> data=permissionService.getPermissionByRoleId(role_id);
        if(data.size()>0){
            result.put("data", data);
        }else{
            result.put("data","没有找到");
        }

        return result;
    }
}

