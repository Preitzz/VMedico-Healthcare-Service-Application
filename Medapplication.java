package com.vmedico.medapp.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Medapplication {
    public static void main(String[] args) {

SpringApplication.run(Medapplication.class, args);
}
}