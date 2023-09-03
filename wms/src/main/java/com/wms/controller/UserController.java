package com.wms.controller;


import com.wms.entity.User;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dengzhouming
 * @since 2023-09-03
 */
@RestController
@RequestMapping("/user")
public class UserController {

   @Resource
    private UserService userService;
    @GetMapping
    public List<User> list(){
        return userService.list();
    }

}
