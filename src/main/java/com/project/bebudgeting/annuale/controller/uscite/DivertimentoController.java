package com.project.bebudgeting.annuale.controller.uscite;

import com.project.bebudgeting.annuale.entity.uscite.DivertimentoUsciteEntity;
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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import javassist.NotFoundException;

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
    @GetMapping(value = "/get-all-altro-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroDivertimentoEntity> getAllAltroDivertimentoEntity() {
        return altroDivertimentoService.findAll();
    }

    @GetMapping(value = "/get-all-attivita-outside-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AttivitaOutsideEntity> getAllAttivitaOutsideEntity() {
        return attivitaOutsideService.findAll();
    }

    @GetMapping(value = "/get-all-concerti-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ConcertiOSpettacoliEntity> getAllConcertiOSpettacoliEntity() {
        return concertiOSpettacoliService.findAll();
    }

    @GetMapping(value = "/get-all-film-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FilmEntity> getAllFilmEntity() {
        return filmService.findAll();
    }

    @GetMapping(value = "/get-all-fotografia-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FotografiaEntity> getAllFotografiaEntity() {
        return fotografiaService.findAll();
    }

    @GetMapping(value = "/get-all-hobby-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<HobbyEntity> getAllHobbyEntity() {
        return hobbyService.findAll();
    }

    @GetMapping(value = "/get-all-libri-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<LibriDivertimentoEntity> getAllLibriDivertimentoEntity() {
        return libriDivertimentoService.findAll();
    }

    @GetMapping(value = "/get-all-musica-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MusicaEntity> getAllMusicaEntity() {
        return musicaService.findAll();
    }

    @GetMapping(value = "/get-all-partita-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PartiteEntity> getAllPartiteEntity() {
        return partiteService.findAll();
    }

    @GetMapping(value = "/get-all-sport-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SportEntity> getAllSportEntity() {
        return sportService.findAll();
    }

    @GetMapping(value = "/get-all-teatro-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TeatroEntity> getAllTeatroEntity() {
        return teatroService.findAll();
    }

    @GetMapping(value = "/get-all-TV-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TVEntity> getAllTVEntity() {
        return tvService.findAll();
    }

    // DELETE ALL
    @DeleteMapping(value = "/delete-all-selected-altri-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltroDivertimentoEntity(@RequestBody Iterable<Integer> ids) {
        altroDivertimentoService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-concerti-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllConcertiDivertimentoEntity(@RequestBody Iterable<Integer> ids) {
        concertiOSpettacoliService.findAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-film-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllFilmDivertimentoEntity(@RequestBody Iterable<Integer> ids) {
        filmService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-fotografia-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllFotografiaDivertimentoEntity(@RequestBody Iterable<Integer> ids) {
        fotografiaService.deleteAllById(ids);

    }

    @DeleteMapping(value = "/delete-all-selected-musica-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllMusicaDivertimentoEntities(@RequestBody Iterable<Integer> ids) {
        musicaService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-partite-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllPartiteDivertimentoService(@RequestBody Iterable<Integer> ids) {
        partiteService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-sport-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllSportDivertimentoService(@RequestBody Iterable<Integer> ids) {
        sportService.findAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-teatro-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllTeatroDivertimentoEntities(@RequestBody Iterable<Integer> ids) {
        teatroService.deleteAllById(ids);
    }

    @DeleteMapping(value = "/delete-all-selected-TV-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllTVDivertimentoEntities(@RequestBody Iterable<Integer> ids) {
        tvService.deleteAllById(ids);

    }

    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-selected-altro-divertimento-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltroDivertimentoEntity(@RequestBody AltroDivertimentoEntity entity) throws NotFoundException {
        altroDivertimentoService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-attivita-outside-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAttivitaOutsideEntity(@RequestBody AttivitaOutsideEntity entity) throws NotFoundException {
        attivitaOutsideService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-concerti-divertimento-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneConcertiDivertimentoEntity(@RequestBody ConcertiOSpettacoliEntity entity)
            throws NotFoundException {
        concertiOSpettacoliService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-film-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneFilmEntity(@RequestBody FilmEntity entity) throws NotFoundException {
        filmService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-fotografia-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneFotografiaEntity(@RequestBody FotografiaEntity entity) throws NotFoundException {
        fotografiaService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-hobby-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneHobbyEntity(@RequestBody HobbyEntity entity) throws NotFoundException {
        hobbyService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-libri-divertimenti-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneLibriDivertimentoEntity(@RequestBody LibriDivertimentoEntity entity) throws NotFoundException {
        libriDivertimentoService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-musica-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneMusicaEntity(@RequestBody MusicaEntity entity) throws NotFoundException {
        musicaService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-partite-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOnePartiteEntity(@RequestBody PartiteEntity entity) throws NotFoundException {
        partiteService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-sport-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSportEntity(@RequestBody SportEntity entity) throws NotFoundException {
        sportService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-teatro-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneTeatroEntity(@RequestBody TeatroEntity entity) throws NotFoundException {
        teatroService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-tv-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void TVEntity(@RequestBody TVEntity entity) throws NotFoundException {
        tvService.delete(entity);
    }

    @DeleteMapping(value = "/delete-one-debiti-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneDebitiEntity(@RequestBody DivertimentoUsciteEntity entity) {
        if (!entity.getAltroEntities().isEmpty()) {
            altroDivertimentoService.deleteAll(entity.getAltroEntities());
        }
        if (!entity.getAttivitaOutsideEntities().isEmpty()) {
            attivitaOutsideService.deleteAll(entity.getAttivitaOutsideEntities());
        }
        if (!entity.getConcertiOSpettacoliEntities().isEmpty()) {
            concertiOSpettacoliService.deleteAll(entity.getConcertiOSpettacoliEntities());
        }
        if (!entity.getFilmEntities().isEmpty()) {
            filmService.deleteAll(entity.getFilmEntities());
        }
        if (!entity.getFotografiaEntities().isEmpty()) {
            fotografiaService.deleteAll(entity.getFotografiaEntities());
        }
        if (!entity.getHobbyEntities().isEmpty()) {
            hobbyService.deleteAll(entity.getHobbyEntities());
        }
        if (!entity.getLibriEntities().isEmpty()) {
            libriDivertimentoService.deleteAll(entity.getLibriEntities());
        }
        if (!entity.getMusicaEntities().isEmpty()) {
            musicaService.deleteAll(entity.getMusicaEntities());
        }
        if (!entity.getPartiteEntities().isEmpty()) {
            partiteService.deleteAll(entity.getPartiteEntities());
        }
        if (!entity.getSportEntities().isEmpty()) {
            sportService.deleteAll(entity.getSportEntities());
        }
        if (!entity.getTeatroEntities().isEmpty()) {
            teatroService.deleteAll(entity.getTeatroEntities());
        }
        if (!entity.getTvEntities().isEmpty()) {
            tvService.deleteAll(entity.getTvEntities());
        }
    }

    // SAVE ONE ENTITY
    @PutMapping(value = "/save-one-altro-divertimento-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AltroDivertimentoEntity saveOneAltroDivertimentoEntity(@RequestBody AltroDivertimentoEntity entity) {
        return altroDivertimentoService.save(entity);
    }

    @PutMapping(value = "/save-one-attivita-outside-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AttivitaOutsideEntity saveOneAttivitaOutsideEntity(@RequestBody AttivitaOutsideEntity entity) {
        return attivitaOutsideService.save(entity);
    }

    @PutMapping(value = "/save-one-concerti-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConcertiOSpettacoliEntity saveOneConcertiEntity(@RequestBody ConcertiOSpettacoliEntity entity) {
        return concertiOSpettacoliService.save(entity);
    }

    @PutMapping(value = "/save-one-film-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FilmEntity saveOneFilmEntity(@RequestBody FilmEntity entity) {
        return filmService.save(entity);
    }

    @PutMapping(value = "/save-one-fotografia-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FotografiaEntity saveOneFotografiaEntity(@RequestBody FotografiaEntity entity) {
        return fotografiaService.save(entity);
    }

    @PutMapping(value = "/save-one-hobby-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HobbyEntity saveOneHobbyEntity(@RequestBody HobbyEntity entity) {
        return hobbyService.save(entity);
    }

    @PutMapping(value = "/save-one-libri-divertimento-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public LibriDivertimentoEntity saveOneLibriDivertimentoEntity(@RequestBody LibriDivertimentoEntity entity) {
        return libriDivertimentoService.save(entity);
    }

    /*
     * @Autowired MusicaService musicaService;
     * 
     * @Autowired PartiteService partiteService;
     * 
     * @Autowired SportService sportService;
     * 
     * @Autowired TeatroService teatroService;
     * 
     * @Autowired TVService tvService;
     */
}
