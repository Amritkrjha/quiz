package com.quiz.question.Controller;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.quiz.question.DTO.*;
import com.quiz.question.Entity.Question;
import com.quiz.question.Entity.Quiz;
import com.quiz.question.Service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@RestController
public class QuestionController {
    
    @Autowired
    QuestionServiceImpl questionService;

    @RequestMapping(method = RequestMethod.POST,value = "/api"+"/questions")
    public ResponseEntity<?> addQuestion(@RequestBody QuestionInputDTO questionInputDTO)
            throws InvalidFormatException, IOException {

        QuestionOutputDTO questionOutputDTO = questionService.createQuestion(questionInputDTO);

        return new ResponseEntity<>(questionOutputDTO, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api"+"/questions"+"/{questionId}")
    public ResponseEntity<?> getQuestionById(@Valid @NotNull @PathVariable("questionId") Long questionId) {
       if(questionId==null){
           FailureResponseDTO failureResponseDTO= new FailureResponseDTO();
           failureResponseDTO.setStatus("failure");
           failureResponseDTO.setReason("Question id is null");
           return new ResponseEntity<>(failureResponseDTO, HttpStatus.NOT_FOUND);
         
       }
        try{
            
            Long.parseLong(String.valueOf(questionId));
        }
        catch (Exception e){
            FailureResponseDTO failureResponseDTO = new FailureResponseDTO();
            failureResponseDTO.setStatus("failure");
            failureResponseDTO.setReason(e.getCause().getLocalizedMessage());
        }
       Question question = questionService.getQuestionById(questionId);
       
        if(question==null){
            QuestionOutputDTO questionOutputDTO = new QuestionOutputDTO();
           return new ResponseEntity<>(questionOutputDTO, HttpStatus.NOT_FOUND);
            
        }
        QuestionOutputDTO questionOutputDTO = new QuestionOutputDTO(question.getQuestionId(),question.getName(),question.getOptions(),
                question.getCorrectAnswer(),question.getQuiz().getQuizId(),question.getPoints());

        return new ResponseEntity<>(questionOutputDTO, HttpStatus.OK);

    }

  
}
