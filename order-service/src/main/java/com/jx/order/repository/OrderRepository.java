package com.jx.order.repository;

import com.jx.order.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Edison Wang
 * @version 1.0
 * @description TODO
 * @date 2023/5/11 13:18
 */

public interface OrderRepository extends JpaRepository<Order,Long> {
}
