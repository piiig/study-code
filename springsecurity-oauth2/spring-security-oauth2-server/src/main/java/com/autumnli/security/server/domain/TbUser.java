package com.autumnli.security.server.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

import javax.persistence.*;

/**
    * 用户表
    */
@Data
@Table(name = "tb_user")
public class TbUser implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "created")
    private Date created;

    @Column(name = "updated")
    private Date updated;
}