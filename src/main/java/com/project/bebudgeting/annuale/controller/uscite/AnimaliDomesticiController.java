package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.AlimentiAnimaliDomesticiService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.AltroAnimaliDomesticiService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.FornitureAnimaliDomesticiService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.GiocattoliAnimaliDomesticiService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.VeterinarioAnimaliDomesticiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Animali Domestici", tags = "Animali Domestici", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/animaliDomestici")
public class AnimaliDomesticiController {
    @Autowired
    AlimentiAnimaliDomesticiService animaliDomesticiService;

    @Autowired
    AltroAnimaliDomesticiService altroAnimaliDomesticiService;

    @Autowired
    FornitureAnimaliDomesticiService fornitureAnimaliDomesticiService;

    @Autowired
    GiocattoliAnimaliDomesticiService giocattoliAnimaliDomesticiService;

    @Autowired
    VeterinarioAnimaliDomesticiService veterinarioAnimaliDOmestici;
}
