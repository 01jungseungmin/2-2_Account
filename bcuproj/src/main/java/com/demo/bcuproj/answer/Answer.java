package com.demo.bcuproj.answer;

import com.demo.bcuproj.question.Question;
import com.demo.bcuproj.user.SiteUser;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private Question question;
    
    @ManyToOne
    private SiteUser author;
    
    private LocalDateTime modifyDate;
    
    @ManyToMany
    Set<SiteUser> voter;
}