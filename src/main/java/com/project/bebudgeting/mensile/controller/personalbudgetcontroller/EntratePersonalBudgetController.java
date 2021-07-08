package com.project.bebudgeting.mensile.controller.personalbudgetcontroller;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.EntrateEffettiveEntity;
import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.EntratePrevisteEntity;
import com.project.bebudgeting.mensile.services.personalbudgetingservices.entrate.EntrateEffettiveService;
import com.project.bebudgeting.mensile.services.personalbudgetingservices.entrate.EntratePrevisteService;
import javassist.NotFoundException;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/entrate")
public class EntratePersonalBudgetController {

    @Autowired
    EntrateEffettiveService entrateEffettiveService;

    @Autowired
    EntratePrevisteService entratePrevisteService;

    //OPERAZIONI SU ENTRATE PREVISTE E EFFETTIVE
    @GetMapping(value = "/effettive/getFilteredActualRevenueByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrateEffettiveEntity findFilteredEntrateEffettive(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return entrateEffettiveService.getFilteredActualRevenueByDate(startDate, endDate);
    }

    @GetMapping(value = "/effettive/getAverageActualRevenueByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getAverageActualRevenueByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return entrateEffettiveService.getAverageActualRevenueByDate(startDate, endDate);
    }

    @GetMapping(value = "/effettive/getFilteredSumActualRevenueByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getFilteredSumActualRevenueByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return entrateEffettiveService.getFilteredSumActualRevenueByDate(startDate, endDate);
    }

    @GetMapping(value = "/previste/getFilteredEstimatedRevenueByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntratePrevisteEntity getFilteredEstimatedRevenueByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return entratePrevisteService.getFilteredEstimatedRevenueByDate(startDate, endDate);
    }

    @GetMapping(value = "/previste/getAverageActualRevenueByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getAverageEstimatedRevenueByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return entratePrevisteService.getAverageEstimatedRevenueByDate(startDate, endDate);
    }

    @GetMapping(value = "/previste/getFilteredSumActualRevenueByDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getFilteredSumEstimatedRevenueByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return entratePrevisteService.getFilteredSumEstimatedRevenueByDate(startDate, endDate);
    }

    @GetMapping(value = "/getPercentageRevenue", produces = MediaType.APPLICATION_JSON_VALUE)
    public BigDecimal getPercentageRevenue() {
        return entratePrevisteService.getPercentageRevenue();
    }

    //OPERAZIONI FONDAMENTALI
    @GetMapping(value = "/effettive/getAllActualRevenue", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrateEffettiveEntity findAllEntrateEffettive() {
        return entrateEffettiveService.getAllActualRevenue();
    }

    @GetMapping(value = "/previste/getAllEstimatedRevenue", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntratePrevisteEntity findAllEntratePreviste() {
        return entratePrevisteService.getAllEstimatedRevenue();
    }

    @PutMapping(value = "/effettive/addActualRevenue", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrateEffettiveEntity addOneEntity(@RequestBody EntrateEffettiveEntity entity) {
        return entrateEffettiveService.addOneEntity(entity);
    }

    @PutMapping(value = "/previste/addEstimatedRevenue", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntratePrevisteEntity addOneEntity(@RequestBody EntratePrevisteEntity entity) {
        return entratePrevisteService.addOneEntity(entity);
    }

    @DeleteMapping(value = "/effettive/deleteOneActualRevenue", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneActualRevenue(@RequestBody EntrateEffettiveEntity entity) throws NotFoundException, NullPointerException, NotImplementedException {
        entrateEffettiveService.deleteOneEntity(entity);
    }

    @DeleteMapping(value = "/previste/deleteOneActualRevenue", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneEstimatedRevenue(@RequestBody EntratePrevisteEntity entity) throws NotFoundException, NullPointerException, NotImplementedException {
        entratePrevisteService.deleteOneEntity(entity);
    }
}
