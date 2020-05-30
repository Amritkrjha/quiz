package com.quiz.question.DTO;

import com.quiz.question.Entity.Quiz;

public class QuestionOutputDTO {
    
    private Long questionId;

    private String name;

    private String options;

    private Integer correctOptions;

    private Long quiz;

    private Integer points;
    
    public QuestionOutputDTO(){
        
    }

    public QuestionOutputDTO(Long questionId, String name, String options, Integer correctOptions, Long quizId, Integer points) {
        this.questionId = questionId;
        this.name = name;
        this.options = options;
        this.correctOptions = correctOptions;
        this.quiz = quiz;
        this.points = points;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

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
