package com.leo.blog.repository;

import com.leo.blog.model.Board;
import com.leo.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

}