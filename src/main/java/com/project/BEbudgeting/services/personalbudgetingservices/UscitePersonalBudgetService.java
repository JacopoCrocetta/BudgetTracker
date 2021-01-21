package com.project.BEbudgeting.services.personalbudgetingservices;

import com.project.BEbudgeting.repositories.personalbudgetrepositories.UscitePersonalBudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UscitePersonalBudgetService {

    @Autowired
    UscitePersonalBudgetRepository repository;
}
