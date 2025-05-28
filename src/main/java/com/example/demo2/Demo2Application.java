package com.example.demo2;

import com.example.demo2.collaborativefiltering.DailyAction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Demo2Application.class);
        application.addListeners(new DailyAction());
        application.run(args);

    }

}
