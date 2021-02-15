package com.project.bebudgeting.controller.personalbudgetcontroller;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.EntrateEffettiveEntity;
import com.project.bebudgeting.services.personalbudgetingservices.entrate.EntrateEffettiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entrateeffettive")
public class EntratePersonalBudgetController {

    @Autowired
    EntrateEffettiveService service;

    @GetMapping(value = "/getAllActualRevenue", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrateEffettiveEntity findAllEntrateEffettive() {
        return service.getAllActualRevenue();
    }
}
