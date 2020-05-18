package com.example.importexcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.importexcel.mapper")
@EntityScan("com.example.importexcel.dao")
//@ComponentScan(basePackages = "com.example.importexcel")
@SpringBootApplication
public class ImportexcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportexcelApplication.class, args);
    }

}
