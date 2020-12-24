package com.example.demo;

import com.example.demo.pojo.People;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
//测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的
@WebAppConfiguration
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Autowired
    People people;

    @Autowired
    ApplicationContext ioc;

    @Autowired
    MockMvc mockMvc;

    @Test//security
    void iocTest(){
        boolean b = ioc.containsBean("getPeople");
        System.out.print(b);
    }

    @Test
    void contextLoads() {
        System.out.print(people);
    }

    @Test
    void details() {
        try {
            String rsp = mockMvc
                    .perform(MockMvcRequestBuilders.get("/hello")
                            .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //添加 MockMvcResultHandlers结果处理器,这是可以用于打印结果输出
//                    .andDo(MockMvcResultHandlers.print())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            System.out.println("rest请求结果如下：\n" + rsp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
