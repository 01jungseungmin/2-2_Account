package com.demo.bcuproj.accountbook.controller;

import com.demo.bcuproj.accountbook.expenditure.ExpenditureForm;
import com.demo.bcuproj.accountbook.expenditure.ExpenditureService;
import com.demo.bcuproj.accountbook.income.IncomeForm;
import com.demo.bcuproj.accountbook.income.IncomeRepository;
import com.demo.bcuproj.accountbook.income.IncomeService;
import com.demo.bcuproj.user.SiteUser;
import com.demo.bcuproj.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@RequestMapping("/accountbook")
@RequiredArgsConstructor
@Controller
public class AccountBookController {

    @Autowired
    private final IncomeRepository incomeRepository;
    private final IncomeService incomeService;

    private final UserService userService;

    private final ExpenditureService expenditureService;

    @RequestMapping("/calendar")
    public String Calendar(){
        return "/calendar_form";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/income")
    public String accountIncome(IncomeForm incomeForm) {
        return "income_form";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/expenditure")
    public String accountExpenditure(ExpenditureForm expenditureForm) {
        return "expenditure_form";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/incoming")
    public String accountIncomeCreate(IncomeForm incomeForm) {
        return "income_form";
    }


    @PreAuthorize("isAuthenticated()")
    @PostMapping("/incoming")
    public String accountIncomePost(@Valid IncomeForm incomeForm, BindingResult bindingResult,Principal principal){
        if(bindingResult.hasErrors()){
            return "income_form";
        }
        SiteUser siteUser=this.userService.gettUser(principal.getName());
        this.incomeService.addIncomeDB(incomeForm.getAmount(),incomeForm.getDate(),incomeForm.getCategory(),incomeForm.getContent(),siteUser);
        return "redirect:/question/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/expendituring")
    public String accountExpenditureCreate(ExpenditureForm expenditureForm) {
        return "expenditure_form";
    }


    @PreAuthorize("isAuthenticated()")
    @PostMapping("/expendituring")
    public String accountExpenditurePost(@Valid ExpenditureForm expenditureForm, BindingResult bindingResult,Principal principal){
        if(bindingResult.hasErrors()){
            return "expenditure_form";
        }
        SiteUser siteUser=this.userService.gettUser(principal.getName());
        this.expenditureService.addExpenditureDB(expenditureForm.getAmount(),expenditureForm.getDate(),expenditureForm.getCategory(),expenditureForm.getContent(),siteUser);
        return "redirect://question/list";
    }

    @RequestMapping("/incomelist")
    public String list(Principal principal, Model model){

        SiteUser siteUser=this.userService.gettUser(principal.getName());

        model.addAttribute("income", incomeService.returnIncomeDB(siteUser));

        return "income_list";
    }

    @RequestMapping("/expenditurelist")
    public String expenditurelist(Principal principal, Model model){

        SiteUser siteUser=this.userService.gettUser(principal.getName());

        model.addAttribute("expenditure", expenditureService.returnExpenditureDB(siteUser));

        return "expenditure_list";
    }


}
