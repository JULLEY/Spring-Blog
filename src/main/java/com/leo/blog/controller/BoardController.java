package com.leo.blog.controller;

import com.leo.blog.config.auth.PrincipalDetail;
import com.leo.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

//    @AuthenticationPrincipal PrincipalDetail principalDetail
    @GetMapping({"", "/"})
    public String index(Model model) {
//        System.out.println("로그인 사용자 아이디 : " + principalDetail.getUsername());

        model.addAttribute("boards", boardService.selectBoardList());
        return "index";
    }

    // USER 권한이 필요
    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
}
