package com.niel.quiz.QuizService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "quiz")
public class Quiz {

    @Id
    private String id;
    private String title;

    @Transient
    private List<Question> questions;
}
