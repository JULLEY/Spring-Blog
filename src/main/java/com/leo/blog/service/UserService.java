package com.leo.blog.service;

import com.leo.blog.model.RoleType;
import com.leo.blog.model.User;
import com.leo.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// 스픨ㅇ이 컴포넌트 스캔을 통해서 Bean에 등록해줌. IoC를 해준다.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void save(User user){

        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

    /*
    @Transactional(readOnly = true) // SELECT 할 때 트랜잭션 시작, 서비스 종료될때 트랜잭션 종료 (정합성 유지)
    public User login(User user){
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
    */
}
