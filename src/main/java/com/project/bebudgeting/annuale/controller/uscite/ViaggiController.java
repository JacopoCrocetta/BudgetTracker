package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.AlimentiViaggiService;
import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.AltroViaggiService;
import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.BigliettiAereiService;
import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.DivertimentoViaggiService;
import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.HotelService;
import com.project.bebudgeting.annuale.service.usciteservice.viaggiservice.TrasportiViaggiService;

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
}
