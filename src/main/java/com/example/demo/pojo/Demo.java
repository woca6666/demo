package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("demo")
public class Demo implements Serializable {

    private Integer id;

    private String name;

    private String age;

    private String adress;

    private String email;

    private String phone;


}
