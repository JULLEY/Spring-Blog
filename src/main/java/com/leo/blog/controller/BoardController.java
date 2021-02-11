package com.leo.blog.controller;

import com.leo.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

//    @AuthenticationPrincipal PrincipalDetail principalDetail
    @GetMapping({"", "/"})
    public String index(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
//        System.out.println("로그인 사용자 아이디 : " + principalDetail.getUsername());

        model.addAttribute("boards", boardService.selectBoardList(pageable));
        return "index";
    }

    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable int id, Model model){
        model.addAttribute("board" , boardService.selectBoardDetail(id));
        return "board/detail";
    }

    // USER 권한이 필요
    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("board", boardService.selectBoardDetail(id));
        return "board/updateForm";
    }
}
