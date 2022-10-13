package com.example.week4jwt.repository;

import com.example.week4jwt.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findAllByOrderByCreatedAtDesc();

}
