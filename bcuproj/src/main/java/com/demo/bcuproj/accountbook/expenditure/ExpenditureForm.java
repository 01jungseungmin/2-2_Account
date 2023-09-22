package com.demo.bcuproj.accountbook.expenditure;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ExpenditureForm {
    @NotNull(message = "금액은 필수항목입니다.")
    private Integer amount;

    @NotEmpty(message = "날짜는 필수항목입니다.")
    private String date;

    private String category;

    @NotEmpty(message = "내용 필수항목입니다.")
    private String content;
}
