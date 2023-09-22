package com.demo.bcuproj.answer;

import com.demo.bcuproj.question.QuestionDto;
import com.demo.bcuproj.user.SiteUserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class AnswerDto {
    private Integer id;
    private String content;
    private LocalDateTime createDate;
    private QuestionDto question;
    private SiteUserDto author;
    private LocalDateTime modifyDate;
    private Set<SiteUserDto> voter;
}