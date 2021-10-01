package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice.AltreSpeseMedicheService;
import com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice.CureSpecialisticheService;
import com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice.DottoriService;
import com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice.EmergenzeService;
import com.project.bebudgeting.annuale.service.usciteservice.spesemedicheservice.FarmaciService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Spese Mediche", tags = "Spese Mediche", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/spese-mediche")
public class SpeseMedicheController {
    @Autowired
    AltreSpeseMedicheService altreSpeseMedicheService;

    @Autowired
    CureSpecialisticheService cureSpecialisticheService;

    @Autowired
    DottoriService dottoriService;

    @Autowired
    EmergenzeService emergenzeService;

    @Autowired
    FarmaciService farmaciService;
}
