package org.simple.maven_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("org.simple")
@EnableJpaRepositories("org.simple.repository")  // Add this
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}