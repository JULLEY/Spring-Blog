package com.leo.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @GetMapping("/test/hello")
    public String test(){
        return "<h2>hello</h2>";
    }
}
