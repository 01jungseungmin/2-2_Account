package com.demo.bcuproj.accountbook.income;

import com.demo.bcuproj.user.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {


    @Autowired
    private IncomeRepository incomeRepository;


    public void addIncomeDB(Integer amount,String date,String category,String content,SiteUser user){
        Income income = new Income();
        income.setAmount(amount);
        income.setDate(date);
        income.setCategory(category);
        income.setContent(content);
        income.setAuthor(user);
        this.incomeRepository.save(income);

    }

    public List<Income> returnIncomeDB(SiteUser user){

        return incomeRepository.findByAuthor(user);
    }


}
