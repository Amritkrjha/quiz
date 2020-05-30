package com.quiz.question.Controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.quiz.question.DTO.FailureResponseDTO;
import com.quiz.question.DTO.QuestionOutputDTO;
import com.quiz.question.DTO.QuizInputDTO;
import com.quiz.question.DTO.QuizOutputDTO;
import com.quiz.question.Entity.Question;
import com.quiz.question.Entity.Quiz;
import com.quiz.question.Service.Impl.QuizService;
import com.quiz.question.Service.QuestionServiceImpl;
import com.quiz.question.Service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizController {
    
    @Autowired
    QuizServiceImpl quizService;
    
    @Autowired
    QuestionServiceImpl questionService;

    @RequestMapping(method = RequestMethod.POST,value = "/api"+"/quiz/")
    public ResponseEntity<?> addQuiz(@RequestBody QuizInputDTO quizInputDTO)
            throws InvalidFormatException, IOException {

        QuizOutputDTO quizOutputDTO = quizService.createQuiz(quizInputDTO);

        return new ResponseEntity<>(quizOutputDTO, HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/api"+"/quiz"+"/{quizId}")
    public ResponseEntity<?> getQuizById(@Valid @NotNull @PathVariable("quizId") Long quizId) {

        if(quizId==null){
            FailureResponseDTO failureResponseDTO= new FailureResponseDTO();
            failureResponseDTO.setStatus("failure");
            failureResponseDTO.setReason("Question id is null");
            return new ResponseEntity<>(failureResponseDTO, HttpStatus.NOT_FOUND);

        }
        try{

            Long.parseLong(String.valueOf(quizId));
        }
        catch (Exception e){
            FailureResponseDTO failureResponseDTO = new FailureResponseDTO();
            failureResponseDTO.setStatus("failure");
            failureResponseDTO.setReason(e.getCause().getLocalizedMessage());
        }
        Quiz quiz = quizService.getQuizById(quizId);

        if(quiz==null){
            QuizOutputDTO quizOutputDTO = new QuizOutputDTO();
            return new ResponseEntity<>(quizOutputDTO, HttpStatus.NOT_FOUND);

        }
        QuizOutputDTO quizOutputDTO = new QuizOutputDTO(quiz.getQuizId(),quiz.getName(),
                quiz.getDescription());

        return new ResponseEntity<>(quizOutputDTO, HttpStatus.OK);


    }
    @RequestMapping(method = RequestMethod.GET, value = "/api"+"/quiz-questions"+"/{quizId}")
    public ResponseEntity<?> getAllQuestionsByQuiz(@Valid @NotNull @PathVariable Long quizId){
        if(quizId==null){
            FailureResponseDTO failureResponseDTO= new FailureResponseDTO();
            failureResponseDTO.setStatus("failure");
            failureResponseDTO.setReason("Question id is null");
            return new ResponseEntity<>(failureResponseDTO, HttpStatus.NOT_FOUND);

        }
        try{

            Long.parseLong(String.valueOf(quizId));
        }
        catch (Exception e){
            FailureResponseDTO failureResponseDTO = new FailureResponseDTO();
            failureResponseDTO.setStatus("failure");
            failureResponseDTO.setReason(e.getCause().getLocalizedMessage());
        }
        Quiz quiz = quizService.getAllQuestionsByQuiz(quizId);

        if(quiz==null){
            QuizOutputDTO quizOutputDTO = new QuizOutputDTO();
            return new ResponseEntity<>(quizOutputDTO, HttpStatus.NOT_FOUND);

        }
        QuizOutputDTO quizOutputDTO = new QuizOutputDTO(quiz.getQuizId(),quiz.getName(),
                quiz.getDescription(),quiz.getQuestions());

        return new ResponseEntity<>(quizOutputDTO, HttpStatus.OK);


    }
}
