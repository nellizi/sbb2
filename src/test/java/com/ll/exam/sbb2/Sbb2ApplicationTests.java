package com.ll.exam.sbb2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class    Sbb2ApplicationTests {

	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	AnswerRepository answerRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void jpaTest1(){
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

		assertThat(q1.getId()).isGreaterThan(0);
		assertThat(q2.getId()).isGreaterThan(q1.getId());


	}
	@Test
	void testJpa2(){
		List<Question> all = questionRepository.findAll();
		assertEquals(2,all.size());

		Question question = all.get(0);
		assertEquals("what is sbb",question.getSubject());
	}

}
