package com.xuexue.im.demo.serve.imserve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huchai
 * @date 2022/12/14
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        System.out.println("test");
        return "test";
    }
}
