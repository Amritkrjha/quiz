package com.quiz.question.Service;

import com.quiz.question.DTO.QuestionInputDTO;
import com.quiz.question.DTO.QuestionOutputDTO;
import com.quiz.question.DTO.QuizInputDTO;
import com.quiz.question.DTO.QuizOutputDTO;
import com.quiz.question.Entity.Question;
import com.quiz.question.Entity.Quiz;
import com.quiz.question.Exception.BadRequestException;
import com.quiz.question.Exception.NoDataExistException;
import com.quiz.question.Exception.NotFoundException;
import com.quiz.question.Repository.QuestionRepository;
import com.quiz.question.Repository.QuizRepository;
import com.quiz.question.Service.Impl.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    
    @Autowired
    QuestionRepository questionRepository;
    
    @Autowired
    QuizRepository quizRepository;
    
    @Override
    public QuestionOutputDTO createQuestion(QuestionInputDTO questionInputDTO) {
        Question question = questionRepository.findByQuizQuizIdAndName(questionInputDTO.getQuiz(),questionInputDTO.getName());
        Quiz quiz=quizRepository.findByQuizId(questionInputDTO.getQuiz());
        String str= questionInputDTO.getOptions();
        String[] values = str.split(",");
        Integer correctOpt = questionInputDTO.getCorrectOptions();
        String correctOptionStr=null;
        for(int i=0;i<values.length;i++){
            if(i==correctOpt){
                correctOptionStr=values[i];
                break;
            }
        }
        if (question==null) {
            question = new Question(questionInputDTO.getName(),questionInputDTO.getOptions(),questionInputDTO.getCorrectOptions()
            ,quiz,questionInputDTO.getPoints());
        } else {
            throw new BadRequestException("already present");

        }
        questionRepository.save(question);
        QuestionOutputDTO questionOutputDTO = new QuestionOutputDTO(question.getQuestionId(),question.getName(),question.getOptions()
        ,question.getCorrectAnswer(),question.getQuiz().getQuizId(),question.getPoints());
        return questionOutputDTO;
    }
    @Override
    public Question getQuestionById(Long questionId) {

        Question question = questionRepository.findByQuestionId(questionId);
        return question;
    }

   
}
