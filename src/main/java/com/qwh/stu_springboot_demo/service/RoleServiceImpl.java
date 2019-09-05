package com.qwh.stu_springboot_demo.service;

import com.qwh.stu_springboot_demo.dao.RoleMapper;
import com.qwh.stu_springboot_demo.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class RoleServiceImpl implements  RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public Role select(Integer id) {
        return roleMapper.select(id);
    }

    @Override
    public int update(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public int delete(Integer id) {
        return roleMapper.delete(id);
    }

    @Override
    public List<Role> getRoleByUserName(String name) {
        return roleMapper.getRoleByUserName(name);
    }
}
