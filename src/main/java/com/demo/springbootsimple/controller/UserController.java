package com.demo.springbootsimple.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.springbootsimple.entity.User;
import com.demo.springbootsimple.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyVetoException;
import java.util.List;

@RestController
@RequestMapping("/user") //给 Contr的oller 中所有方法统一加一个路径前缀，避免每个方法都重复写路径
public class UserController {

    @Resource
   private UserMapper userMapper;

    //RESTful 风格写法：
    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping
    public String save(@RequestBody User user){
        return "用户新增成功";
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping
    public Page<User> getAll(){
        return userMapper.selectPage(new Page<User>(1,10),new LambdaUpdateWrapper<>());
    }

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id){
        return "查询单个用户成功";
    }

    /**
     * 修改用户
     * @param id
     * @param user
     * @return
     */
    @PutMapping
    public String update(@PathVariable Long id,@RequestBody User user){
        return "修改用户成功";
    }

    /**
     * 删除单个用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return "删除用户成功";
    }
}
