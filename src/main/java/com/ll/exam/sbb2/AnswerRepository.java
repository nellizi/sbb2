package com.ll.exam.sbb2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {    //< 엔티티타입, 엔티티의 pk속성의 타입>
}

