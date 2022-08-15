package com.ll.exam.sbb2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findBySubject(String subject);
    Question findById(int id);

    Question findBySubjectAndContent(String subject, String cotent);



    List<Question> findBySubjectLike(String subjectBites); //두개 이상 나올 수 있으니까 리스트로 받기

    @Transactional
    @Modifying
    @Query(value = "truncate question", nativeQuery = true)
    void truncate();

}
