package com.qwh.stu_springboot_demo.service;

import com.qwh.stu_springboot_demo.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public int insertUser(User user);
    public int insertSelective(User user);
    public User findUser(Integer id);
    public User selectUserByName(String name);
    public int updateUser(User user);
    public int updateSelective(User user);
    public List<User> findAll();
    public  int deleteUser(Integer id);
    public List<Map<String, Object>> getAllQXByUserName(String name);
}
