package com.project.bebudgeting.controller.annuali.usciteannuali;

import com.project.bebudgeting.entity.annuali.uscite.DivertimentoUsciteEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.AltroDivertimentoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.AttivitaOutsideEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.ConcertiOSpettacoliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.FilmEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.FotografiaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.HobbyEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.LibriDivertimentoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.MusicaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.PartiteEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.SportEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.TVEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodivertimento.TeatroEntity;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.AltroDivertimentoService;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.AttivitaOutsideService;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.ConcertiOSpettacoliService;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.FilmService;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.FotografiaService;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.HobbyService;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.LibriDivertimentoService;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.MusicaService;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.PartiteService;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.SportService;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.TVService;
import com.project.bebudgeting.service.annuali.usciteservice.divertimentoservice.TeatroService;

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

    /**
     * @return Iterable<AltroDivertimentoEntity>
     */
    // FIND ALL
    @GetMapping(value = "/get-all-altro-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AltroDivertimentoEntity> getAllAltroDivertimentoEntity() {
        return altroDivertimentoService.findAll();
    }

    /**
     * @return Iterable<AttivitaOutsideEntity>
     */
    @GetMapping(value = "/get-all-attivita-outside-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AttivitaOutsideEntity> getAllAttivitaOutsideEntity() {
        return attivitaOutsideService.findAll();
    }

    /**
     * @return Iterable<ConcertiOSpettacoliEntity>
     */
    @GetMapping(value = "/get-all-concerti-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ConcertiOSpettacoliEntity> getAllConcertiOSpettacoliEntity() {
        return concertiOSpettacoliService.findAll();
    }

    /**
     * @return Iterable<FilmEntity>
     */
    @GetMapping(value = "/get-all-film-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FilmEntity> getAllFilmEntity() {
        return filmService.findAll();
    }

    /**
     * @return Iterable<FotografiaEntity>
     */
    @GetMapping(value = "/get-all-fotografia-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FotografiaEntity> getAllFotografiaEntity() {
        return fotografiaService.findAll();
    }

    /**
     * @return Iterable<HobbyEntity>
     */
    @GetMapping(value = "/get-all-hobby-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<HobbyEntity> getAllHobbyEntity() {
        return hobbyService.findAll();
    }

    /**
     * @return Iterable<LibriDivertimentoEntity>
     */
    @GetMapping(value = "/get-all-libri-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<LibriDivertimentoEntity> getAllLibriDivertimentoEntity() {
        return libriDivertimentoService.findAll();
    }

    /**
     * @return Iterable<MusicaEntity>
     */
    @GetMapping(value = "/get-all-musica-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MusicaEntity> getAllMusicaEntity() {
        return musicaService.findAll();
    }

    /**
     * @return Iterable<PartiteEntity>
     */
    @GetMapping(value = "/get-all-partita-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<PartiteEntity> getAllPartiteEntity() {
        return partiteService.findAll();
    }

    /**
     * @return Iterable<SportEntity>
     */
    @GetMapping(value = "/get-all-sport-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<SportEntity> getAllSportEntity() {
        return sportService.findAll();
    }

    /**
     * @return Iterable<TeatroEntity>
     */
    @GetMapping(value = "/get-all-teatro-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TeatroEntity> getAllTeatroEntity() {
        return teatroService.findAll();
    }

    /**
     * @return Iterable<TVEntity>
     */
    @GetMapping(value = "/get-all-TV-divertimento-entities", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<TVEntity> getAllTVEntity() {
        return tvService.findAll();
    }

    /**
     * @param ids
     */
    // DELETE ALL
    @DeleteMapping(value = "/delete-all-selected-altri-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllAltroDivertimentoEntity(@RequestBody Iterable<Integer> ids) {
        altroDivertimentoService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-selected-concerti-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllConcertiDivertimentoEntity(@RequestBody Iterable<Integer> ids) {
        concertiOSpettacoliService.findAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-selected-film-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllFilmDivertimentoEntity(@RequestBody Iterable<Integer> ids) {
        filmService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-selected-fotografia-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllFotografiaDivertimentoEntity(@RequestBody Iterable<Integer> ids) {
        fotografiaService.deleteAllById(ids);

    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-selected-musica-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllMusicaDivertimentoEntities(@RequestBody Iterable<Integer> ids) {
        musicaService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-selected-partite-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllPartiteDivertimentoService(@RequestBody Iterable<Integer> ids) {
        partiteService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-selected-sport-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllSportDivertimentoService(@RequestBody Iterable<Integer> ids) {
        sportService.findAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-selected-teatro-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllTeatroDivertimentoEntities(@RequestBody Iterable<Integer> ids) {
        teatroService.deleteAllById(ids);
    }

    /**
     * @param ids
     */
    @DeleteMapping(value = "/delete-all-selected-TV-divertimento-entities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAllTVDivertimentoEntities(@RequestBody Iterable<Integer> ids) {
        tvService.deleteAllById(ids);

    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    // DELETE ONE ENTITY
    @DeleteMapping(value = "/delete-one-selected-altro-divertimento-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAltroDivertimentoEntity(@RequestBody AltroDivertimentoEntity entity) throws NotFoundException {
        altroDivertimentoService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-attivita-outside-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneAttivitaOutsideEntity(@RequestBody AttivitaOutsideEntity entity) throws NotFoundException {
        attivitaOutsideService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-concerti-divertimento-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneConcertiDivertimentoEntity(@RequestBody ConcertiOSpettacoliEntity entity)
            throws NotFoundException {
        concertiOSpettacoliService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-film-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneFilmEntity(@RequestBody FilmEntity entity) throws NotFoundException {
        filmService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-fotografia-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneFotografiaEntity(@RequestBody FotografiaEntity entity) throws NotFoundException {
        fotografiaService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-hobby-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneHobbyEntity(@RequestBody HobbyEntity entity) throws NotFoundException {
        hobbyService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-libri-divertimenti-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneLibriDivertimentoEntity(@RequestBody LibriDivertimentoEntity entity) throws NotFoundException {
        libriDivertimentoService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-musica-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneMusicaEntity(@RequestBody MusicaEntity entity) throws NotFoundException {
        musicaService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-partite-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOnePartiteEntity(@RequestBody PartiteEntity entity) throws NotFoundException {
        partiteService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-sport-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneSportEntity(@RequestBody SportEntity entity) throws NotFoundException {
        sportService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-teatro-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteOneTeatroEntity(@RequestBody TeatroEntity entity) throws NotFoundException {
        teatroService.delete(entity);
    }

    /**
     * @param entity
     * @throws NotFoundException
     */
    @DeleteMapping(value = "/delete-one-tv-entity", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void TVEntity(@RequestBody TVEntity entity) throws NotFoundException {
        tvService.delete(entity);
    }

    /**
     * @param entity
     */
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

    /**
     * @param entity
     * @return AltroDivertimentoEntity
     */
    // SAVE ONE ENTITY
    @PutMapping(value = "/save-one-altro-divertimento-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AltroDivertimentoEntity saveOneAltroDivertimentoEntity(@RequestBody AltroDivertimentoEntity entity) {
        return altroDivertimentoService.save(entity);
    }

    /**
     * @param entity
     * @return AttivitaOutsideEntity
     */
    @PutMapping(value = "/save-one-attivita-outside-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AttivitaOutsideEntity saveOneAttivitaOutsideEntity(@RequestBody AttivitaOutsideEntity entity) {
        return attivitaOutsideService.save(entity);
    }

    /**
     * @param entity
     * @return ConcertiOSpettacoliEntity
     */
    @PutMapping(value = "/save-one-concerti-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ConcertiOSpettacoliEntity saveOneConcertiEntity(@RequestBody ConcertiOSpettacoliEntity entity) {
        return concertiOSpettacoliService.save(entity);
    }

    /**
     * @param entity
     * @return FilmEntity
     */
    @PutMapping(value = "/save-one-film-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FilmEntity saveOneFilmEntity(@RequestBody FilmEntity entity) {
        return filmService.save(entity);
    }

    /**
     * @param entity
     * @return FotografiaEntity
     */
    @PutMapping(value = "/save-one-fotografia-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FotografiaEntity saveOneFotografiaEntity(@RequestBody FotografiaEntity entity) {
        return fotografiaService.save(entity);
    }

    /**
     * @param entity
     * @return HobbyEntity
     */
    @PutMapping(value = "/save-one-hobby-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HobbyEntity saveOneHobbyEntity(@RequestBody HobbyEntity entity) {
        return hobbyService.save(entity);
    }

    /**
     * @param entity
     * @return LibriDivertimentoEntity
     */
    @PutMapping(value = "/save-one-libri-divertimento-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public LibriDivertimentoEntity saveOneLibriDivertimentoEntity(@RequestBody LibriDivertimentoEntity entity) {
        return libriDivertimentoService.save(entity);
    }

    /**
     * @param entity
     * @return MusicaEntity
     */
    @PutMapping(value = "/save-one-musica-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public MusicaEntity saveOneMusicaEntity(@RequestBody MusicaEntity entity) {
        return musicaService.save(entity);
    }

    /**
     * @param entity
     * @return PartiteEntity
     */
    @PutMapping(value = "/save-one-partite-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PartiteEntity saveOnePartiteEntity(@RequestBody PartiteEntity entity) {
        return partiteService.save(entity);
    }

    /**
     * @param entity
     * @return SportEntity
     */
    @PutMapping(value = "/save-one-sport-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public SportEntity saveOneSportEntity(@RequestBody SportEntity entity) {
        return sportService.save(entity);
    }

    /**
     * @param entity
     * @return TeatroEntity
     */
    @PutMapping(value = "/save-one-teatro-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TeatroEntity saveOneTeatroEntity(@RequestBody TeatroEntity entity) {
        return teatroService.save(entity);
    }

    /**
     * @param entity
     * @return TVEntity
     */
    @PutMapping(value = "/save-one-tv-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TVEntity saveOneTVEntity(@RequestBody TVEntity entity) {
        return tvService.save(entity);
    }

    /**
     * @param entity
     * @return DivertimentoUsciteEntity
     */
    @PutMapping(value = "/save-one-divertimento-entity", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DivertimentoUsciteEntity saveOneDivertimentoEntity(@RequestBody DivertimentoUsciteEntity entity) {
        altroDivertimentoService.saveAll(entity.getAltroEntities());
        attivitaOutsideService.saveAll(entity.getAttivitaOutsideEntities());
        concertiOSpettacoliService.saveAll(entity.getConcertiOSpettacoliEntities());
        filmService.saveAll(entity.getFilmEntities());
        fotografiaService.saveAll(entity.getFotografiaEntities());
        hobbyService.saveAll(entity.getHobbyEntities());
        libriDivertimentoService.saveAll(entity.getLibriEntities());
        musicaService.saveAll(entity.getMusicaEntities());
        partiteService.saveAll(entity.getPartiteEntities());
        sportService.saveAll(entity.getSportEntities());
        teatroService.saveAll(entity.getTeatroEntities());
        tvService.saveAll(entity.getTvEntities());

        return entity;
    }
}
