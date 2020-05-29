package com.quiz.question.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "question",schema = "schema")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "question_id")
    private Long questionId;
    
    @Column(name="name")
    private String name;

    @Column(name="options")
    private String options;

   @Column(name="correct_answer")
   private Integer correctAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    
    @Column(name="points")
    private Integer points;
    
    public Question(){
        
    }

    public Question(String name, String options, Integer correctAnswer, Quiz quiz, Integer points) {
        this.name = name;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.quiz = quiz;
        this.points = points;
    }

    public Question(Long questionId, String name, String answer, Integer correctAnswer, Quiz quiz, Integer points) {
        this.questionId = questionId;
        this.name = name;
        this.options = options;
        this.correctAnswer = correctAnswer;
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

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
