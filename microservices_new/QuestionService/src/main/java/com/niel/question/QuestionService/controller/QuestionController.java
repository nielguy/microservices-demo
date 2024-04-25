package com.niel.question.QuestionService.controller;

import com.niel.question.QuestionService.model.Question;
import com.niel.question.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService=questionService;
    }

    @PostMapping
    public ResponseEntity<Question> create(@RequestBody Question question) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.create(question));
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getAll());
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<Question> getOne(@PathVariable String questionId) {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getOne(questionId));
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>> getQuestionsOfQuiz(@PathVariable String quizId) {
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestionsOfQuiz(quizId));
    }
}
