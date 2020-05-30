package com.quiz.question.Service.Impl;

import com.quiz.question.Controller.QuizController;
import com.quiz.question.DTO.QuizInputDTO;
import com.quiz.question.DTO.QuizOutputDTO;
import com.quiz.question.Entity.Question;
import com.quiz.question.Entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
    
    public QuizOutputDTO createQuiz(QuizInputDTO quizInputDTO);

    public Quiz getQuizById(Long quizId);

    public Quiz getAllQuestionsByQuiz(Long quizId);
}
