package com.qwh.stu_springboot_demo.controller;

import com.qwh.stu_springboot_demo.domain.User;
import com.qwh.stu_springboot_demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/shiro")
public class ShiroController {
    @Autowired
    private UserService userService;


    @RequestMapping("/loginShiro/{username}/{password}")

    public Object loginShiro(@PathVariable("username") String username, @PathVariable("password") String password){

        if(username != null){
            User user = userService.selectUserByName(username);
            if(user != null && user.getPassword().equals(password)){
                //添加用户信息
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
                //进行验证，这里可以捕获异常，然后返回对应信息
                subject.login(usernamePasswordToken);
                System.out.println("loginShiro:"+usernamePasswordToken);
                return "loginShiro!";
            }
        }
        //调用通过logout后通过setLoginUrl重新进入该方法
        return "it is logout!";
    }

    @RequestMapping("/logout")
    public Object logout(){
        return "It is logout";
    }

    @RequestMapping("/index")
    public Object index(){
        return "It is index";
    }

    @RequestMapping("/errorpage")
    public Object error(){
        return "It is error";
    }

    @RequestMapping("/testShiro/{test}")
    public Object testShiro(@PathVariable String test){
        //业务方法
        return "testShiro:success!";
    }

    //认证角色
    @RequestMapping("/testAuthorityRole")
    @RequiresRoles(value = {"admin","user"},logical = Logical.OR)
    public Object testAuthorityRole(){
        return "testAuthority:success!";
    }

    //认证操作权限
    @RequestMapping("/testAuthorityPermission")
    @RequiresPermissions(value = {"update","create"},logical = Logical.OR)
    //默认逻辑是and的关系，两个都要同时满足，换成or只要满足其中一个就行
    public Object testAuthorityPermission(){
        return "testAuthorityPermission:success!";
    }

    @RequestMapping("/testRolesAndPermission")
    @RequiresRoles(value = {"admin"})
    @RequiresPermissions(value = {"create","select"})
    public Object testRolesAndPermission(){
        return "testRolesAndPermission:success!";
    }
}
