package com.demo.springbootsimple.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.springbootsimple.common.Result;
import com.demo.springbootsimple.entity.User;
import com.demo.springbootsimple.mapper.UserMapper;
import com.demo.springbootsimple.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyVetoException;
import java.util.List;

@RestController
@RequestMapping("/user") //给 Contr的oller 中所有方法统一加一个路径前缀，避免每个方法都重复写路径
public class UserController {

    @Resource
    private UserService userService;

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public Result doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return Result.success("登录成功");
        }
        return Result.error("登录失败");
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public Result isLogin() {
        return Result.success("当前会话是否登录：" + StpUtil.isLogin());
    }


    //RESTful 风格写法：
    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping
    public Result save(@RequestBody User user){

        return Result.success(userService.save(user));
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping
    public Result getAll(){

        return Result.success(userService.list());
    }

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getOne(@PathVariable Long id){
        return Result.success(userService.getById(id));
    }

    /**
     * 修改用户
     * @param id
     * @param user
     * @return
     */
    @PutMapping({"/{id}"})
    public Result update(@PathVariable Long id,@RequestBody User user){
        return Result.success(userService.updateById(user));
    }

    /**
     * 删除单个用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return Result.success(userService.removeById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize,@RequestParam(defaultValue = "")String name){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
       if (!"".equals(name)&&name!=null){
           lambdaQueryWrapper.like(User::getName,name);
       }
        return Result.success(userService.page(new Page<>(pageNum,pageSize),lambdaQueryWrapper));
    }
}
