package com.niel.quiz.QuizService.repository;

import com.niel.quiz.QuizService.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
}
