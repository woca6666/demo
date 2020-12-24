package com.example.demo.controller;

import com.example.demo.config.PeopleConfig;
import com.example.demo.pojo.Demo;
import com.example.demo.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TestHello {

    @Autowired
    PeopleConfig peopleConfig;

    @Autowired
    IDemoService iDemoService;

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String sayHello(){
        return peopleConfig.getPeople().toString();
    }

    @ResponseBody
    @RequestMapping(value = "/add")
    public String adds(){
        long l = System.currentTimeMillis();

//        List<Demo> list = new ArrayList<>();
        Demo demo = new Demo();
        for (int i = 0; i <1000; i++){
//            Demo demo = new Demo();
            demo.setName("name"+i);
            demo.setAdress("adress"+i);
            demo.setAge("age"+i);
            demo.setEmail("email"+i);
            demo.setPhone("phone"+i);
//            list.add(demo);
            iDemoService.save(demo);
        }
//        iDemoService.saveBatch(list);
        log.info("耗时："+(System.currentTimeMillis() - l));
        return "success";
    }
}
