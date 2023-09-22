package com.demo.bcuproj.accountbook.expenditure;

import com.demo.bcuproj.user.SiteUserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenditureDto {
    private Integer amount;
    private String date;
    private String category;
    private String content;
    private SiteUserDto author;
}
