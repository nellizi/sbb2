package com.ll.exam.sbb2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question findBySubject(String subject);
    Question findById(int id);

    Question findBySubjectAndContent(String subject, String cotent);


    List<Question> findBySubjectLike(String subjectBites);
    //두개 이상 나올 수 있으니까 리스트로 받기
}
