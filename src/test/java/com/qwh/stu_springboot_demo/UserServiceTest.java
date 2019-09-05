package com.qwh.stu_springboot_demo;

import com.qwh.stu_springboot_demo.domain.Permission;
import com.qwh.stu_springboot_demo.domain.User;
import com.qwh.stu_springboot_demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

   // @Test
    public void selectByPrimaryKey() {

        User user = userService.findUser(1);
        System.out.println(user.getName());
    }

       @Test
    public void getAllQXByUserName() {
        List<Map<String, Object>> all = userService.getAllQXByUserName("qwh");
        for(int i=0;i<all.size();i++){
            System.out.println(all.get(i).keySet());
            for (String key : all.get(i).keySet()) {
                System.out.println(all.get(i).get(key));
            }
        }

        /*
            Map<String, Object> all = userService.getAllQXByUserName("ztt");
            for (String key : all.keySet()) {
            String row = "role_name：" + key;
            List<Permission> obj = (List) all.get(key);
            row += ",permisson:";
            for (Permission p : obj) {
                row += p.getPermission() + ",";
            }
            System.out.println(row);
        }
         */

    }
}
