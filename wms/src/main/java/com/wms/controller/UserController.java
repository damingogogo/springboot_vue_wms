package com.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.QueryPageParam;
import com.wms.entity.User;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

   @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }


    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }

    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return userService.updateById(user);
    }

    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    //删除1   格式/delete/3
    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

    //删除2   格式delete?id=3
    @GetMapping("/delete")
    public boolean delete1(Integer id){
        return userService.removeById(id);
    }


    //查询（模糊，匹配）
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,user.getName());
        return userService.list(lambdaQueryWrapper);
    }

    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam queryPageParam){

        HashMap map=queryPageParam.getParam();
        String name = (String) map.get("name");
        /*
        System.out.println(name);

        String no = (String) map.get("no");
        System.out.println(no);

         */

        //MP分页
        Page<User> page=new Page<>(queryPageParam.getPageNum(),queryPageParam.getPageSize());
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,name);
        Page<User> userPage = userService.page(page, lambdaQueryWrapper);

        return userPage.getRecords();
    }
}
