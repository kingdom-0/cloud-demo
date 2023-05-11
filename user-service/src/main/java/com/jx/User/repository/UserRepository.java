package com.jx.User.repository;

import com.jx.User.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Edison Wang
 * @version 1.0
 * @description TODO
 * @date 2023/5/11 13:45
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
