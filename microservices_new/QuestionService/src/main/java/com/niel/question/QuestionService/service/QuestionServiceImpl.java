package com.niel.question.QuestionService.service;

import com.niel.question.QuestionService.model.Question;
import com.niel.question.QuestionService.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository=questionRepository;
    }

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(String questionId) {
        return questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(String quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
