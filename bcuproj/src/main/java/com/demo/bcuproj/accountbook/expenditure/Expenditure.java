package com.demo.bcuproj.accountbook.expenditure;

import com.demo.bcuproj.user.SiteUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Expenditure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer amount;

    private String date;

    private String category;

    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private SiteUser author;
}