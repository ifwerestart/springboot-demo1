package com.qwh.stu_springboot_demo.service;

import com.qwh.stu_springboot_demo.dao.PermissionMapper;
import com.qwh.stu_springboot_demo.domain.Permission;
import com.qwh.stu_springboot_demo.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class PermissionServiceImpl implements  PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public int insert(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public Permission select(Integer id) {
        return permissionMapper.select(id);
    }

    @Override
    public int update(Permission permission) {
        return permissionMapper.update(permission);
    }

    @Override
    public int delete(Integer id) {
        return permissionMapper.delete(id);
    }

    @Override
    public List<Permission> getPermissionByRoleId(int role_id) {
        return permissionMapper.getPermissionByRoleId(role_id);
    }
}
