package com.example.demo;

import com.example.demo.wsdl.GetUserResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    CommandLineRunner lookup(UserClient quoteClient) {
        return args -> {
            String user = "Jane";

            if (args.length > 0) {
                user = args[0];
            }
            GetUserResponse response = quoteClient.getUser(user);
           // System.err.println(response.getUser().getCurrency());
        };
    }
}
