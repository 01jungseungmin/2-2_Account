package com.demo.bcuproj.accountbook.income;

import com.demo.bcuproj.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Integer> {
    List<Income> findByAuthor(SiteUser user);

}
