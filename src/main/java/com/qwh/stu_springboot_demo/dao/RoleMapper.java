package com.qwh.stu_springboot_demo.dao;

import com.qwh.stu_springboot_demo.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleMapper {

    public int insert(Role role);
    public Role select(Integer id);
    public int update(Role role);
    public  int delete(Integer id);
    List<Role> getRoleByUserName(String name);

}
