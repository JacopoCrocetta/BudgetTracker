package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.casaservice.AffittoService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.AltroCasaService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.ArredamentoService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.FornitureCasaService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.ManutenzioneService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.MiglioramentiService;
import com.project.bebudgeting.annuale.service.usciteservice.casaservice.TraslocoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Casa", tags = "Casa", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/casa")
public class CasaController {
    @Autowired
    AffittoService affittoService;

    @Autowired
    AltroCasaService altroCasaService;

    @Autowired
    ArredamentoService arredamentoService;

    @Autowired
    FornitureCasaService fornitureCasaService;

    @Autowired
    ManutenzioneService manutenzioneService;

    @Autowired
    MiglioramentiService miglioramentiService;

    @Autowired
    TraslocoService traslocoService;
}
