package com.quiz.question.Service;

import com.quiz.question.DTO.QuizInputDTO;
import com.quiz.question.DTO.QuizOutputDTO;
import com.quiz.question.Entity.Question;
import com.quiz.question.Entity.Quiz;
import com.quiz.question.Exception.BadRequestException;
import com.quiz.question.Exception.NoDataExistException;
import com.quiz.question.Exception.NotFoundException;
import com.quiz.question.Repository.QuizRepository;
import com.quiz.question.Service.Impl.QuizService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Override
    public QuizOutputDTO createQuiz(QuizInputDTO quizInputDTO) {
        Quiz quiz = new Quiz(quizInputDTO.getName(),quizInputDTO.getDescription());
        quizRepository.save(quiz);
        QuizOutputDTO quizOutputDTO = new QuizOutputDTO(quiz.getQuizId(), quiz.getName(), quiz.getDescription(), quiz.getQuestions());
        return quizOutputDTO;
    }

    @Override
    public Quiz getQuizById(Long quizId) {

        Quiz quiz = quizRepository.findByQuizId(quizId);
        if (quiz == null) {
            throw new NotFoundException("not found");
        }
        return quiz;
    }

    @Override
    public Quiz getAllQuestionsByQuiz(Long quizId) {
        Quiz quiz = quizRepository.findByQuizId(quizId);
        return quiz;
    }
}
        
