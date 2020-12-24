package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.DemoDao;
import com.example.demo.pojo.Demo;
import com.example.demo.service.IDemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl extends ServiceImpl<DemoDao, Demo> implements IDemoService {
}
