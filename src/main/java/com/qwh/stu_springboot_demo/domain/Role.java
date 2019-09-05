package com.qwh.stu_springboot_demo.domain;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private  String role_name;
    private  Integer user_id;
    private List<Permission> permissions;
}
