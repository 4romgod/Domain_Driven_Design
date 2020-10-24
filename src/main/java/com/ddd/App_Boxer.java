package com.ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // same as @EnableAutoConfiguration @Configuration @ComponentScan
public class App_Boxer {

    public static void main(String[] args){
        SpringApplication.run(App_Boxer.class, args);
    }

}
