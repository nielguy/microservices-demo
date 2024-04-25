package com.niel.question.QuestionService.service;

import com.niel.question.QuestionService.model.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);

    List<Question> getAll();

    Question getOne(String questionId);

    List<Question> getQuestionsOfQuiz(String quizId);

}
