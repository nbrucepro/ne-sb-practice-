package com.mbyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class MbyjApplication {
    public static void main(String[]  args) {

        SpringApplication.run(MbyjApplication.class,args);
        System.out.println("I'm running...");
    }
}
