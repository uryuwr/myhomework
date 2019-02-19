package com.ch.user.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author Chen on 2019-02-04-21:01
 */
@Data
@Entity
@Table(name = "t0_test")
public class Registry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20)",unique = true)
    @Size(min = 6,max = 20,message = "用户名大于6，小于20")
    private String userName;

    private String password;
}
