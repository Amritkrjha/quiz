package com.quiz.question.Repository;

import com.quiz.question.Entity.Question;
import com.quiz.question.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    Question findByQuestionId(Long questionId);

    Optional<Question> findByName(String name);
    
    Question findByQuizQuizIdAndName(Long quizId,String name);
    
}
