package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.AltriPrestitiService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.AltroDebitiService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.CarteCreditoService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.ImposteLocaliService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.ImposteStataliService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.PrestitiPerStudioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Debiti", tags = "Debiti", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/debiti")
public class DebitiController {
    @Autowired
    AltriPrestitiService altriPrestitiService;

    @Autowired
    AltroDebitiService altroDebitiService;

    @Autowired
    CarteCreditoService carteCreditoService;

    @Autowired
    ImposteLocaliService imposteLocaliService;

    @Autowired
    ImposteStataliService imposteStataliService;

    @Autowired
    PrestitiPerStudioService prestitiPerStudioService;
}
