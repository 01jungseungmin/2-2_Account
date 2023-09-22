package com.demo.bcuproj.accountbook.income;

import com.demo.bcuproj.user.SiteUserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomeDto {
    private Integer amount;
    private String date;
    private String category;
    private String content;
    private SiteUserDto author;
}
