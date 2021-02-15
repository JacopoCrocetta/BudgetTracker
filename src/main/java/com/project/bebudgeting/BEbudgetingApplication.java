package com.project.bebudgeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class BEbudgetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BEbudgetingApplication.class, args);
    }

}
