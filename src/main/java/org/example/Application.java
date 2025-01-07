package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example")
public class Application {
    public static void main(String[] args) {

        org.springframework.boot.SpringApplication.run(Application.class, args);
    }
}
