package com.jx.order.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Edison Wang
 * @version 1.0
 * @description TODO
 * @date 2023/5/11 11:29
 */

@Data
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, unique = false)
    private double price;

    @Column(nullable = true, unique = false)
    private Integer num;

    @Column(nullable = false, unique = false)
    private Long userId;

    @Transient
    private User user;
}
