package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.AltreUsciteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Altre Uscite", tags = "Altre Uscite", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/altre-uscite")
public class AltreUsciteController {
    @Autowired
    AltreUsciteService altreUsciteService;
}
