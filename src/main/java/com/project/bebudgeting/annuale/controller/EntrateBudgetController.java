package com.project.bebudgeting.annuale.controller;

import com.project.bebudgeting.annuale.entity.EntrateAnnualiEntity;
import com.project.bebudgeting.annuale.service.EntrateAnnualiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/entrateAnnuali")
public class EntrateBudgetController {
    @Autowired
    EntrateAnnualiService entrateAnnualiService;

    @GetMapping(value = "/getAllEntrate", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntrateAnnualiEntity> findAll(){
        return entrateAnnualiService.findAll();
    }

    @GetMapping(value ="/getAllEntrateById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<EntrateAnnualiEntity> findAll(@RequestBody Iterable<Integer> ids){
        return entrateAnnualiService.findAllById(ids);
    }

    @GetMapping(value ="/getEntrateById", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<EntrateAnnualiEntity> findById(@RequestParam int id){
        return entrateAnnualiService.findById(id);
    }
}
