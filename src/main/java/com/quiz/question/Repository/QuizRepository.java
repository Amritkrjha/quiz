package com.quiz.question.Repository;

import com.quiz.question.Entity.Question;
import com.quiz.question.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {

    Quiz findByQuizId(Long quizId);
    
    Optional<Quiz> findByName(String name);

   
}
