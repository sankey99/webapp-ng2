package com.cs.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by sankey on 2017-05-15.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.cs.common"})
public  class TestApplication{
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
   }
}