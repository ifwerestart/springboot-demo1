package com.qwh.stu_springboot_demo.dao;

import com.qwh.stu_springboot_demo.domain.Permission;
import com.qwh.stu_springboot_demo.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionMapper {
    public int insert(Permission permission);
    public Permission select(Integer id);
    public int update(Permission permission);
    public  int delete(Integer id);
    List<Permission> getPermissionByRoleId(int role_id);
}
