package com.quiz.question.Service.Impl;


import com.quiz.question.DTO.QuestionInputDTO;
import com.quiz.question.DTO.QuestionOutputDTO;
import com.quiz.question.Entity.Question;
import com.quiz.question.Entity.Quiz;

import java.util.List;

public interface QuestionService {

    public QuestionOutputDTO createQuestion(QuestionInputDTO questionInputDTO);

    public Question getQuestionById(Long questionId);

    
    
    
}
