package com.niel.question.QuestionService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "question")
public class Question {

    @Id
    private String questionId;
    private String question;
    private String quizId;
}
