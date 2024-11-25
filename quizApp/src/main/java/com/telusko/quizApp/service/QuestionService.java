package com.telusko.quizApp.service;

import com.telusko.quizApp.Question;
import com.telusko.quizApp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private QuestionDao questionDao;

    @Autowired
    QuestionService(QuestionDao questionDao){
        this.questionDao = questionDao;
    }

    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getQuestionById(Integer id) {
        return questionDao.findById(id)
                .map(question -> new ResponseEntity<>(question, HttpStatus.OK))
                //,map(question-> ResponseEntity.ok(question)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> findByDifficulty(String difficultyLevel) {
        return questionDao.findQuestionByDifficultyLevel(difficultyLevel)
                .map(question -> ResponseEntity.ok(question))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> saveQuestion(Question question) {
        try {
            Question savedQuestion = questionDao.save(question);
            return ResponseEntity.status(HttpStatus.CREATED).body("savedQuestion");
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
