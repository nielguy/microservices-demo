package com.niel.quiz.QuizService.service;

import com.niel.quiz.QuizService.model.Quiz;

import java.util.List;

public interface QuizService {

    Quiz create(Quiz quiz);

    List<Quiz> getAll();

    Quiz getOne(String id);
}
