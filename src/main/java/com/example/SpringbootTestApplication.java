package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ginger
 */
@Slf4j
@SpringBootApplication
public class SpringbootTestApplication {

    public static void main(String[] args) {


        SpringApplication.run(SpringbootTestApplication.class, args);
        log.info("项目启动");
    }

}
