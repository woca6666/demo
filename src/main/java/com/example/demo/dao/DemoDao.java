package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Demo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoDao extends BaseMapper<Demo> {
}
