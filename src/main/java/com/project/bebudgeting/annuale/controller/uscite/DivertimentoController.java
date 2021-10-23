package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.AltroDivertimentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.AttivitaOutsideEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.ConcertiOSpettacoliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.FilmEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.FotografiaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.HobbyEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.LibriDivertimentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.MusicaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.PartiteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.SportEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.TVEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.TeatroEntity;
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
import org.springframework.web.bind.annotation.GetMapping;
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

    // FIND ALL
    @GetMapping
    public Iterable<AltroDivertimentoEntity> getAllAltroDivertimentoEntity() {
        return altroDivertimentoService.findAll();
    }

    @GetMapping
    public Iterable<AttivitaOutsideEntity> getAllAttivitaOutsideEntity() {
        return attivitaOutsideService.findAll();
    }

    @GetMapping
    public Iterable<ConcertiOSpettacoliEntity> getAllConcertiOSpettacoliEntity() {
        return concertiOSpettacoliService.findAll();
    }

    @GetMapping
    public Iterable<FilmEntity> getAllFilmEntity() {
        return filmService.findAll();
    }

    @GetMapping
    public Iterable<FotografiaEntity> getAllFotografiaEntity() {
        return fotografiaService.findAll();
    }

    @GetMapping
    public Iterable<HobbyEntity> getAllHobbyEntity() {
        return hobbyService.findAll();
    }

    @GetMapping
    public Iterable<LibriDivertimentoEntity> getAllLibriDivertimentoEntity() {
        return libriDivertimentoService.findAll();
    }

    @GetMapping
    public Iterable<MusicaEntity> getAllMusicaEntity() {
        return musicaService.findAll();
    }

    @GetMapping
    public Iterable<PartiteEntity> getAllPartiteEntity() {
        return partiteService.findAll();
    }

    @GetMapping
    public Iterable<SportEntity> getAllSportEntity() {
        return sportService.findAll();
    }

    @GetMapping
    public Iterable<TeatroEntity> getAllTeatroEntity() {
        return teatroService.findAll();
    }

    @GetMapping
    public Iterable<TVEntity> getAllTVEntity() {
        return tvService.findAll();
    }
    // DELETE ALL
}
