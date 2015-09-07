package com.daumkakao.jpa

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.web.SpringBootServletInitializer

/**
 * Created by kellin on 9/7/15.
 */
@SpringBootApplication
class Application extends SpringBootServletInitializer {

    static void main (String[] args) {
        SpringApplication.run(Application.class, args)

        println("Spring Boot Started.");
    }
}
