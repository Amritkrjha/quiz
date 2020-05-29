package com.quiz.question.DTO;

import com.quiz.question.Entity.Quiz;

public class QuestionInputDTO {

    private String name;
    
    private String options;
    
    private Integer correctOptions;

    private Long quiz;
    
    private Integer points;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Integer getCorrectOptions() {
        return correctOptions;
    }

    public void setCorrectOptions(Integer correctOptions) {
        this.correctOptions = correctOptions;
    }

    public Long getQuiz() {
        return quiz;
    }

    public void setQuiz(Long quiz) {
        this.quiz = quiz;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
