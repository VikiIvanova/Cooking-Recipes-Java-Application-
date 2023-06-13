package com.example.demo.repository;

import com.example.demo.model.PostedComments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostedCommentsRepository extends JpaRepository<PostedComments, Long> {
}
