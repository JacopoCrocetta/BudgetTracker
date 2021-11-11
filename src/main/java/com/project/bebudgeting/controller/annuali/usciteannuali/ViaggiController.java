package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.AlimentiViaggiEntity;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.AlimentiViaggiService;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.AltroViaggiService;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.BigliettiAereiService;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.DivertimentoViaggiService;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.HotelService;
import com.project.bebudgeting.service.annuali.usciteservice.viaggiservice.TrasportiViaggiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Viaggi", tags = "Viaggi", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/viaggi")
public class ViaggiController {
    @Autowired
    AlimentiViaggiService alimentiViaggiService;

    @Autowired
    AltroViaggiService altroViaggiService;

    @Autowired
    BigliettiAereiService bigliettiAereiService;

    @Autowired
    DivertimentoViaggiService divertimentoViaggiService;

    @Autowired
    HotelService hotelService;

    @Autowired
    TrasportiViaggiService trasportiViaggiService;

    // FIND ALL

    public Iterable<AlimentiViaggiEntity> getAllAlimentiViaggiEntities() {
        return alimentiViaggiService.findAll();
    }
}
