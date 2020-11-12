package com.leo.blog.repository;

import com.leo.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// DAO
// 자동으로 bean등록
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
