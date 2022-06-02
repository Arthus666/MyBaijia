package com.dream.mybaijia;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Arthus
 */
@SpringBootApplication
@MapperScan("com.dream.mybaijia.mapper")
@ServletComponentScan("com.dream.mybaijia.filter")
public class MybaijiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybaijiaApplication.class, args);
    }

}
