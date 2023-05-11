package com.jx.User.pojo;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Edison Wang
 * @version 1.0
 * @description TODO
 * @date 2023/5/11 10:46
 */

@Data
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = false)
    private String username;

    @Column(nullable = false, unique = false)
    private String address;
}
