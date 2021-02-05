package com.leo.blog.service;

import com.leo.blog.model.Board;
import com.leo.blog.model.RoleType;
import com.leo.blog.model.User;
import com.leo.blog.repository.BoardRepository;
import com.leo.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void save(Board board, User user){
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }
}
