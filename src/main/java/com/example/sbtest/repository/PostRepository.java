package com.example.sbtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sbtest.domain.Board;

@Repository
public interface PostRepository extends JpaRepository<Board, Integer> {

}
