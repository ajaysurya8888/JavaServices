package com.telusko.quizApp.dao;

import com.telusko.quizApp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    Optional<?> findQuestionByDifficultyLevel(String difficultyLevel);
}
