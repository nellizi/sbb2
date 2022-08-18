package com.ll.exam.sbb2.question;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
public class QuestionForm {
    @Size(max = 200, message = "제목을 200자 이하로 입력해주세요.")
    private String subject;
    private String content;
}
