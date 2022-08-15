package com.ll.exam.sbb2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Sbb2ApplicationTests {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;

    @Test
    void contextLoads() {
    }




    @BeforeEach
    void beforeEach(){
        questionRepository.disableForeignKeyChecks();
        questionRepository.truncate();
        questionRepository.enableForeignKeyChecks();

        jpaTest1();
    }

    @Test
    void jpaTest1() {
        Question q1 = new Question();
        q1.setSubject("what is sbb");
        q1.setContent("wanna know about sbb");
        q1.setCreateDate(LocalDateTime.now());
        questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("Q about sbb model");
        q2.setContent("does id create automatically?");
        q2.setCreateDate(LocalDateTime.now());
        questionRepository.save(q2);

    }

    @Test
    void testJpa2() {
        List<Question> all = questionRepository.findAll();
        assertEquals(2, all.size());

        Question question = all.get(0);
        assertEquals("what is sbb", question.getSubject());
    }

    @Test
    void testJpa3() {
        Question q = questionRepository.findBySubject("what is sbb");
        assertEquals(1, q.getId());
    }

    @Test
    void testJpa4() {
        Question q = questionRepository.findBySubjectAndContent("what is sbb", "wanna know about sbb");
        assertEquals(1, q.getId());
    }
    @Test
    void testJpa5(){
        List<Question>qList = questionRepository.findBySubjectLike("what%");
        Question question = qList.get(0);
        assertEquals("what is sbb",question.getSubject());
    }

    @Test
    void testJpa6(){
        Question q = questionRepository.findById(1);
        q.setSubject("new subJect");
        q.setContent("new Content");
        questionRepository.save(q);

//     findById는 Optional로 정의되어 있기 때문에 이렇게 사용해야 하지만
//     QuestionReporitory에 findById 오버라이딩 해서 그냥 사용하는 방법으로 실행
//        Optional <Question> oq = questionRepository.findById(7);
//        assertTrue(oq.isPresent());
//        Question question =oq.get();
//        question.setSubject("modified title");
//        questionRepository.save(question);

    }
    @Test
    void testJpa7() {
        Question q = questionRepository.findById(1);
        questionRepository.delete(q);
    }


}
