package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.AltroDivertimentoService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.AttivitaOutsideService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.ConcertiOSpettacoliService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.FilmService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.FotografiaService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.HobbyService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.LibriDivertimentoService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.MusicaService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.PartiteService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.SportService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.TVService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.TeatroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Divertimento", tags = "Divertimento", description = "REST APIs related to Salario Entity")
@RestController
@RequestMapping("/divertimento")
public class DivertimentoController {
    @Autowired
    AltroDivertimentoService altroDivertimentoService;

    @Autowired
    AttivitaOutsideService attivitaOutsideService;

    @Autowired
    ConcertiOSpettacoliService concertiOSpettacoliService;

    @Autowired
    FilmService filmService;

    @Autowired
    FotografiaService fotografiaService;

    @Autowired
    HobbyService hobbyService;

    @Autowired
    LibriDivertimentoService libriDivertimentoService;

    @Autowired
    MusicaService musicaService;

    @Autowired
    PartiteService partiteService;

    @Autowired
    SportService sportService;

    @Autowired
    TeatroService teatroService;

    @Autowired
    TVService tvService;
}
