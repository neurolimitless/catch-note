package com.hido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class ApplicationInitializer {
  public static void main(String[] args) {
    SpringApplication.run(ApplicationInitializer.class, args);
  }
}
