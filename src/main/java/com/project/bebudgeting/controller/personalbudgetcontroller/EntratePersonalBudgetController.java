package com.project.bebudgeting.controller.personalbudgetcontroller;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.EntrateEffettiveEntity;
import com.project.bebudgeting.entities.personalbudgetingentity.entrate.EntratePrevisteEntity;
import com.project.bebudgeting.services.personalbudgetingservices.entrate.EntrateEffettiveService;
import com.project.bebudgeting.services.personalbudgetingservices.entrate.EntratePrevisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/entrate")
public class EntratePersonalBudgetController {

    @Autowired
    EntrateEffettiveService entrateEffettiveService;

    @Autowired
    EntratePrevisteService entratePrevisteService;

    @GetMapping(value = "/effettive/getAllActualRevenue", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrateEffettiveEntity findAllEntrateEffettive() {
        return entrateEffettiveService.getAllActualRevenue();
    }

    @GetMapping(value = "/effettive/getFilteredActualRevenueByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrateEffettiveEntity findFilteredEntrateEffettive(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return entrateEffettiveService.getFilteredActualRevenueByDate(startDate, endDate);
    }

    @GetMapping(value = "/effettive/getAverageActualRevenueByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getAverageActualRevenueByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return entrateEffettiveService.getAverageActualRevenueByDate(startDate, endDate);
    }

    @GetMapping(value = "/effettive/getAverageActualRevenueByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getFilteredSumActualRevenueByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return entrateEffettiveService.getFilteredSumActualRevenueByDate(startDate, endDate);
    }

    @GetMapping(value = "/previste/getAllActualRevenue", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntratePrevisteEntity findAllEntratePreviste(){
        return entratePrevisteService.getAllEstimatedRevenue();
    }

    @GetMapping(value = "/previste/getFilteredEstimatedRevenueByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntratePrevisteEntity getFilteredEstimatedRevenueByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return entratePrevisteService.getFilteredEstimatedRevenueByDate(startDate, endDate);
    }

    @GetMapping(value = "/previste/getAverageActualRevenueByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getAverageEstimatedRevenueByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return entratePrevisteService.getAverageEstimatedRevenueByDate(startDate, endDate);
    }
}
