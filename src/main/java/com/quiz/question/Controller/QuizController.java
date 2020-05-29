package com.quiz.question.Controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
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

    @RequestMapping(method = RequestMethod.POST,value = "/api"+"/quiz")
    public ResponseEntity<?> addBook(@RequestBody QuizInputDTO quizInputDTO)
            throws InvalidFormatException, IOException {

        QuizOutputDTO quizOutputDTO = quizService.createQuiz(quizInputDTO);

        return new ResponseEntity<>(quizOutputDTO, HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/api"+"/quiz"+"/{quizId}")
    public ResponseEntity<Quiz> getBookById(@Valid @NotNull @PathVariable("quizId") Long quizId) {

        Quiz quiz = quizService.getQuizById(quizId);

        return new ResponseEntity<>(quiz, HttpStatus.OK);

    }
    @RequestMapping(method = RequestMethod.GET, value = "/api"+"/question/quiz"+"/{quizId}")
    public ResponseEntity<List<QuestionOutputDTO>> getQuestions(@Valid @NotNull @PathVariable Long quizId){
        List<Question> quizList=quizService.getAllQuestionsByQuiz(quizId);
        List<QuestionOutputDTO> questionOutputDTOList=new ArrayList<>();
        for(Question question: quizList){
            QuestionOutputDTO questionOutputDTO=new QuestionOutputDTO(question.getQuestionId(),question.getName()
            ,question.getOptions(),question.getCorrectAnswer(),null,question.getPoints());
            questionOutputDTOList.add(questionOutputDTO);
        }
        return new ResponseEntity<>(questionOutputDTOList, HttpStatus.OK);
    }
}
