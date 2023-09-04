package com.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YUANBO
 * @create 2019-02-16 9:57
 **/
@RestController
public class SpringBootController {

    @RequestMapping("/test")
    public String testController(){
        return "hello SpringBoot!!";
    }
}
