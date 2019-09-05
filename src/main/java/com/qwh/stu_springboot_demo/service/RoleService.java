package com.qwh.stu_springboot_demo.service;

import com.qwh.stu_springboot_demo.domain.Role;

import java.util.List;

public interface RoleService {
    public int insert(Role role);
    public Role select(Integer id);
    public int update(Role role);
    public  int delete(Integer id);
    List<Role> getRoleByUserName(String name);
}
