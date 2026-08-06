package com.demo.springbootsimple;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.demo.springbootsimple.entity.User;
import com.demo.springbootsimple.mapper.UserMapper;
import com.demo.springbootsimple.util.RedisUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
class SpringbootSimpleApplicationTests {
    @Resource
    private UserMapper userMapper;//依赖注入(DI)

    @Resource
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        /*System.out.println("---selectAll method test---");

        // 1. 修正语法：直接传 null，不写 queryWrapper:
        List<User> userList = userMapper.selectList(null);

        // 2. 先打印实际数据条数，看看是多少
        System.out.println("实际数据条数：" + userList.size());

        // 3. 打印所有用户信息
        userList.forEach(user -> {
            System.out.println("用户：" + user.getName() + "，年龄：" + user.getAge());
        });

        // 4. 修改断言：改成 > 0（只要有数据就行）
        Assert.isTrue(userList.size() > 0, "数据库中没有数据！");
        System.out.println("✅ 测试通过！共 " + userList.size() + " 条数据");

        redisUtil.set("userList",userList);*/
        System.out.println(redisUtil.get("userList"));
    }
}
