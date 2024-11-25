package com.telusko.quizApp.controller;

import com.telusko.quizApp.Question;
import com.telusko.quizApp.service.QuestionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {
    private QuestionService questionService;
    @Autowired
    QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return questionService.getAllQuestion();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable Integer id) {
        return questionService.getQuestionById(id);
    }
    @GetMapping("/difficulty/{difficultyLevel}")
    public ResponseEntity<?> findByDifficulty(@PathVariable String difficultyLevel) {
        return questionService.findByDifficulty(difficultyLevel);
    }
    @PostMapping("/")
    public ResponseEntity<?> saveQuestion(@RequestBody Question question) {
        questionService.saveQuestion(question);
        return ResponseEntity.ok("Question saved successfully!");
    }
}



