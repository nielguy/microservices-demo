package com.niel.quiz.QuizService.service;

import com.niel.quiz.QuizService.model.Question;
import com.niel.quiz.QuizService.model.Quiz;
import com.niel.quiz.QuizService.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;
    private QuestionClient questionClient;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository=quizRepository;
        this.questionClient=questionClient;
    }

    @Override
    public Quiz create(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz getOne(String id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }
}
