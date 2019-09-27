package com.qf.springboot_studentmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@MapperScan("com.qf.dao")
public class SpringbootStudentmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStudentmanagerApplication.class, args);
    }

}
