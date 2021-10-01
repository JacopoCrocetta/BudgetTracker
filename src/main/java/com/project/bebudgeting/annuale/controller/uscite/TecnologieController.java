package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.tecnologiaservice.AltroTecnologiaService;
import com.project.bebudgeting.annuale.service.usciteservice.tecnologiaservice.HardwareService;
import com.project.bebudgeting.annuale.service.usciteservice.tecnologiaservice.HostingService;
import com.project.bebudgeting.annuale.service.usciteservice.tecnologiaservice.ServiziOnlineService;
import com.project.bebudgeting.annuale.service.usciteservice.tecnologiaservice.SoftwareService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Tecnologia", tags = "Tecnologia", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/tecnologie")
public class TecnologieController {
    @Autowired
    AltroTecnologiaService altroTecnologiaService;

    @Autowired
    HardwareService hardwareService;

    @Autowired
    HostingService hostingService;

    @Autowired
    ServiziOnlineService serviziOnlineService;

    @Autowired
    SoftwareService softwareService;
}
