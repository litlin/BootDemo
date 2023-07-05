package com.linlite.bootdemo.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "users")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    private String email;
    @Column(nullable = false)
    private String password;

    private String rememberToken;

    private Date createdAt;

    private Date updatedAt;
}
