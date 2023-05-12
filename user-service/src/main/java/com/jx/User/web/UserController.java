package com.jx.User.web;

import com.jx.User.entity.User;
import com.jx.User.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Edison Wang
 * @version 1.0
 * @description TODO
 * @date 2023/5/11 10:47
 */

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //@Value("${pattern.dateformat}")
    private String dateformat;

    @GetMapping("/{userId}")
    public User queryById(@PathVariable("userId") long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/now")
    public String getDateTimeNow(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
    }
}
