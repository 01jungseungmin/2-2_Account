package com.demo.bcuproj.question;

import com.demo.bcuproj.answer.AnswerDto;
import com.demo.bcuproj.user.SiteUserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class QuestionDto {
    private Integer id;
    private String subject;
    private String content;
    private LocalDateTime createDate;
    private List<AnswerDto> answerList;
    private SiteUserDto author;
    private LocalDateTime modifyDate;
    private Set<SiteUserDto> voter;
}