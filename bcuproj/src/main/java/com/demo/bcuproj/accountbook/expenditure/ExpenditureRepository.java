package com.demo.bcuproj.accountbook.expenditure;

import com.demo.bcuproj.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Integer> {
    List<Expenditure> findByAuthor(SiteUser user);
}
