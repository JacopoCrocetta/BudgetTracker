package com.project.bebudgeting.annuale.controller;

import com.project.bebudgeting.annuale.service.UsciteAnnualiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usciteAnnuali")
public class UsciteBudgetController {
    @Autowired
    UsciteAnnualiService usciteAnnualiService;
}
