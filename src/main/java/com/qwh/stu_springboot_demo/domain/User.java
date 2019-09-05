package com.qwh.stu_springboot_demo.domain;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.util.List;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private  double sal;
    private List<Role> roles;


}
