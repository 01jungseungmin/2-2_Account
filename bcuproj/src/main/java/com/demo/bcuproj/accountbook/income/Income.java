package com.demo.bcuproj.accountbook.income;

import com.demo.bcuproj.user.SiteUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Income {
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
