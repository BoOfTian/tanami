package com.example.learnspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller // TODO 问题：为什么使用@Controller时浏览器访问下面hello接口会报错404，而使用@RestController时却时正常的呢？
//Answer：在使用@Controller注解时，必须配合模版来使用，模版引擎支持：FreeMarker，Groovy，Thymeleaf，Thymeleaf等，需要使用相应等试图解析器去解析视图，很明显，我们并不存在hello.html或hello.jsp这样的文件
// 而使@RestController注解时，默认返回的是文本格式文件，如json，当然也可以返回xml
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name) throws Exception {
//        long startTime = System.currentTimeMillis();
        Thread.sleep(Math.round(Math.random() * 100));
        System.out.println("执行Controller的hello方法");
//        System.out.println("执行时间："+(System.currentTimeMillis()-startTime)+"毫秒");
        return "你好，打工人！";
    }
}
