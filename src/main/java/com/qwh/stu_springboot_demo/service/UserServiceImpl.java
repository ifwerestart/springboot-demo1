package com.qwh.stu_springboot_demo.service;

import com.qwh.stu_springboot_demo.dao.UserMapper;
import com.qwh.stu_springboot_demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Primary
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserMapper usermapper;

    @Override
    public int insertUser(User user) {
        return usermapper.insertUser(user);

    }

    @Override
    public int insertSelective(User user) {
        return usermapper.insertSelective(user);

    }

    @Override
    public User findUser(Integer id) {
        return usermapper.findUser(id);
    }

    @Override
    public User selectUserByName(String name) {
        return  usermapper.selectUserByName(name);
    }

    @Override
    public int updateUser(User user) {
       return usermapper.updateUser(user);

    }

    @Override
    public int updateSelective(User user) {
        return usermapper.updateSelective(user);

    }

    @Override
    public List<User> findAll() {
        return usermapper.findAll();
    }

    @Override
    public int deleteUser(Integer id) {
       return  usermapper.deleteUser(id);

    }

    @Override
    public List<Map<String, Object>> getAllQXByUserName(String name) {
        return usermapper.getAllQXByUserName(name);
    }
}
