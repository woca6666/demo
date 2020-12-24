package com.example.demo.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import java.io.File;
/**
 *    文件上传设置
 *
 */
@Configuration
public class MultipartConfig {
    /**
     * 设置临时路径
     * @return
     */
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        String location = System.getProperty("user.dir") + "/data/tmp";
        File tmpFile = new File(location);
        if (!tmpFile.exists()) {
            tmpFile.mkdirs();
        }
        //文件最大  
        factory.setMaxFileSize(DataSize.ofBytes(10240000));
        factory.setMaxRequestSize(DataSize.ofBytes(1024000000));
        factory.setFileSizeThreshold(DataSize.ofBytes(1024));
        factory.setLocation(location);
        return factory.createMultipartConfig();
    }

}
