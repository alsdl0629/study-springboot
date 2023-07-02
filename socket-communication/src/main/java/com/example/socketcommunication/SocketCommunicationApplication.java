package com.example.socketcommunication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class SocketCommunicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocketCommunicationApplication.class, args);
    }

}
