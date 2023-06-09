package com.datamanage.datamanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class DatamanageApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatamanageApplication.class, args);
    }

}
