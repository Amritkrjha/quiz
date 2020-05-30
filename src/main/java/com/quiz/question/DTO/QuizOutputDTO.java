package com.quiz.question.DTO;

import com.quiz.question.Entity.Question;

import java.util.List;

public class QuizOutputDTO {
    
    private Long quizId;
    
    private String name;
    
    private String description;

    private List<Question> questions;
    public QuizOutputDTO(){
        
    }

    public QuizOutputDTO(Long quizId, String name, String description) {
        this.quizId = quizId;
        this.name = name;
        this.description = description;
    }

    public QuizOutputDTO(Long quizId, String name, String description, List<Question> questions) {
        this.quizId = quizId;
        this.name = name;
        this.description = description;
        this.questions = questions;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
