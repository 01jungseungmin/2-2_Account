package com.demo.bcuproj.accountbook.expenditure;


import com.demo.bcuproj.user.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenditureService {

    @Autowired
    private ExpenditureRepository expenditureRepository;

    public void addExpenditureDB(Integer amount, String date, String category, String content, SiteUser user){
        Expenditure expenditure = new Expenditure();
        expenditure.setAmount(amount);
        expenditure.setDate(date);
        expenditure.setCategory(category);
        expenditure.setContent(content);
        expenditure.setAuthor(user);
        this.expenditureRepository.save(expenditure);

    }
    public List<Expenditure> returnExpenditureDB(SiteUser user){

        return expenditureRepository.findByAuthor(user);
    }
}
