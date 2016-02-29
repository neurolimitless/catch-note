package com.catchnote.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@ComponentScan({"com.catchnote.springmvc.config"})
@PropertySource(value = {"classpath:application.properties"})
public class MailConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(environment.getRequiredProperty("mail.host"));
        javaMailSender.setPort(Integer.parseInt(environment.getRequiredProperty("mail.port")));
        javaMailSender.setUsername(environment.getRequiredProperty("mail.username"));
        javaMailSender.setPassword(environment.getRequiredProperty("mail.password"));
        javaMailSender.setJavaMailProperties(javaMailProperties());
        return javaMailSender;
    }

    private Properties javaMailProperties() {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", environment.getRequiredProperty("mail.transport.protocol"));
        properties.put("mail.smtp.auth", environment.getRequiredProperty("mail.smtp.auth"));
        properties.put("mail.smtp.starttls.enable", environment.getRequiredProperty("mail.smtp.starttls.enable"));
        properties.put("mail.debug", environment.getRequiredProperty("mail.debug"));
        properties.put("mail.smtp.port", environment.getRequiredProperty("mail.smtp.port"));
        return properties;
    }

}
