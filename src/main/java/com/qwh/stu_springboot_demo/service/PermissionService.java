package com.qwh.stu_springboot_demo.service;

import com.qwh.stu_springboot_demo.domain.Permission;
import com.qwh.stu_springboot_demo.domain.Role;

import java.util.List;

public interface PermissionService {
    public int insert(Permission permission);
    public Permission select(Integer id);
    public int update(Permission permission);
    public  int delete(Integer id);
    List<Permission> getPermissionByRoleId(int role_id);
}
