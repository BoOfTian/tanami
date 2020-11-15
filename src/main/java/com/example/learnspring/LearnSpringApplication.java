package com.example.learnspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.*")//设置扫包路径，若不设置，在该启动类包外（除去与该类平级的及其子类）的controller将被不包含在内，导致访问时404
public class LearnSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringApplication.class, args);
    }
//IDEA快捷键连接：https://www.jianshu.com/p/9fe8131155a9
}
