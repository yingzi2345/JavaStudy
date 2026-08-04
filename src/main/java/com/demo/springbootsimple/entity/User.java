package com.demo.springbootsimple.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@TableName("`user`")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(value = "create_time")//属性名不一致时，用这个注解映射
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//返回格式
    private LocalDateTime createTime;
    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
