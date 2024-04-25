package com.niel.quiz.QuizService.controller;

import com.niel.quiz.QuizService.model.Quiz;
import com.niel.quiz.QuizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService=quizService;
    }

    @PostMapping
    public ResponseEntity<Quiz> create(@RequestBody Quiz quiz) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.create(quiz));
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getAll());
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getOne(@PathVariable String quizId) {
        return ResponseEntity.status(HttpStatus.OK).body(quizService.getOne(quizId));
    }
}
