package com.niel.quiz.QuizService.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Question {

    private String questionId;
    private String question;
    private String quizId;
}
