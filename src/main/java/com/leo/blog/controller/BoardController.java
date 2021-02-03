package com.leo.blog.controller;

import com.leo.blog.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

//    @AuthenticationPrincipal PrincipalDetail principalDetail
    @GetMapping({"", "/"})
    public String index() {
//        System.out.println("로그인 사용자 아이디 : " + principalDetail.getUsername());
        return "index";
    }

    // USER 권한이 필요
    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
}
