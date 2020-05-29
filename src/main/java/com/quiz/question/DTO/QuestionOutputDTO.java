package com.quiz.question.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.quiz.question.Entity.Quiz;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionOutputDTO {
    
    private Long questionId;

    private String name;

    private String options;

    private Integer correctOptions;

    private Long quizId;

    private Integer points;
    
    public QuestionOutputDTO(){
    }
    

    public QuestionOutputDTO(Long questionId, String name, String options, Integer correctOptions, Long quizId, Integer points) {
        this.questionId = questionId;
        this.name = name;
        this.options = options;
        this.correctOptions = correctOptions;
        this.quizId = quizId;
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

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
