package com.project.bebudgeting.annuale.service.usciteservice;

import com.project.bebudgeting.annuale.entity.uscite.DivertimentoEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.DivertimentoRepository;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.AltroDivertimentoService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.AttivitaOutsideService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.ConcertiOSpettacoliService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.FilmService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.FotografiaService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.HobbyService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.LibriService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.MusicaService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.PartiteService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.SportService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.TVService;
import com.project.bebudgeting.annuale.service.usciteservice.divertimentoservice.TeatroService;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivertimentoService {
    @Autowired
    DivertimentoRepository repository;

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
    LibriService libriService;

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

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        altroDivertimentoService.deleteAll();
        attivitaOutsideService.deleteAll();
        concertiOSpettacoliService.deleteAll();
        filmService.deleteAll();
        hobbyService.deleteAll();
        libriService.deleteAll();
        musicaService.deleteAll();
        musicaService.deleteAll();
        partiteService.deleteAll();
        sportService.deleteAll();
        teatroService.deleteAll();
        tvService.deleteAll();
        repository.deleteAll();
    }

    public void delete(DivertimentoEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            if (repository.findById(entity.getId()).isPresent()) {
                if (!repository.findById(entity.getId()).get().getAltroEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getAltroEntities().forEach(altroEntity -> {
                        try {
                            altroDivertimentoService.delete(altroEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(entity.getId()).get().getAttivitaOutsideEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getAttivitaOutsideEntities()
                            .forEach(attivitaOutsideEntity -> {
                                try {
                                    attivitaOutsideService.delete(attivitaOutsideEntity);
                                } catch (NotFoundException e) {
                                    e.printStackTrace();
                                }
                            });
                }
                if (!repository.findById(entity.getId()).get().getConcertiOSpettacoliEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getConcertiOSpettacoliEntities()
                            .forEach(concertiOSpettacoliEntity -> {
                                try {
                                    concertiOSpettacoliService.delete(concertiOSpettacoliEntity);
                                } catch (NotFoundException e) {
                                    e.printStackTrace();
                                }
                            });
                }
                if (!repository.findById(entity.getId()).get().getFilmEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getFilmEntities().forEach(filmEntity -> {
                        try {
                            filmService.delete(filmEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(entity.getId()).get().getFotografiaEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getFotografiaEntities().forEach(fotografiaEntity -> {
                        try {
                            fotografiaService.delete(fotografiaEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(entity.getId()).get().getHobbyEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getHobbyEntities().forEach(hobbyEntity -> {
                        try {
                            hobbyService.delete(hobbyEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(entity.getId()).get().getLibriEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getLibriEntities().forEach(libriEntity -> {
                        try {
                            libriService.delete(libriEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(entity.getId()).get().getMusicaEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getMusicaEntities().forEach(musicaEntity -> {
                        try {
                            musicaService.delete(musicaEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(entity.getId()).get().getPartiteEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getPartiteEntities().forEach(partiteEntity -> {
                        try {
                            partiteService.delete(partiteEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(entity.getId()).get().getSportEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getSportEntities().forEach(sportEntity -> {
                        try {
                            sportService.delete(sportEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(entity.getId()).get().getTeatroEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getTeatroEntities().forEach(teatroEntity -> {
                        try {
                            teatroService.delete(teatroEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(entity.getId()).get().getTvEntities().isEmpty()) {
                    repository.findById(entity.getId()).get().getTvEntities().forEach(tvEntity -> {
                        try {
                            tvService.delete(tvEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                repository.delete(entity);
            } else {
                throw new NotFoundException("Item not present");
            }
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<DivertimentoEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            if (repository.findById(id).isPresent()) {
                if (!repository.findById(id).get().getAltroEntities().isEmpty()) {
                    repository.findById(id).get().getAltroEntities().forEach(altroEntity -> {
                        try {
                            altroDivertimentoService.deleteById(altroEntity.getId());
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getAttivitaOutsideEntities().isEmpty()) {
                    repository.findById(id).get().getAttivitaOutsideEntities().forEach(attivitaOutsideEntity -> {
                        try {
                            attivitaOutsideService.delete(attivitaOutsideEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getConcertiOSpettacoliEntities().isEmpty()) {
                    repository.findById(id).get().getConcertiOSpettacoliEntities()
                            .forEach(concertiOSpettacoliEntity -> {
                                try {
                                    concertiOSpettacoliService.delete(concertiOSpettacoliEntity);
                                } catch (NotFoundException e) {
                                    e.printStackTrace();
                                }
                            });
                }
                if (!repository.findById(id).get().getFilmEntities().isEmpty()) {
                    repository.findById(id).get().getFilmEntities().forEach(filmEntity -> {
                        try {
                            filmService.delete(filmEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getFotografiaEntities().isEmpty()) {
                    repository.findById(id).get().getFotografiaEntities().forEach(fotografiaEntity -> {
                        try {
                            fotografiaService.delete(fotografiaEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getHobbyEntities().isEmpty()) {
                    repository.findById(id).get().getHobbyEntities().forEach(hobbyEntity -> {
                        try {
                            hobbyService.delete(hobbyEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getLibriEntities().isEmpty()) {
                    repository.findById(id).get().getLibriEntities().forEach(libriEntity -> {
                        try {
                            libriService.delete(libriEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getMusicaEntities().isEmpty()) {
                    repository.findById(id).get().getMusicaEntities().forEach(musicaEntity -> {
                        try {
                            musicaService.delete(musicaEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getPartiteEntities().isEmpty()) {
                    repository.findById(id).get().getPartiteEntities().forEach(partiteEntity -> {
                        try {
                            partiteService.delete(partiteEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getSportEntities().isEmpty()) {
                    repository.findById(id).get().getSportEntities().forEach(sportEntity -> {
                        try {
                            sportService.deleteById(sportEntity.getId());
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getTeatroEntities().isEmpty()) {
                    repository.findById(id).get().getTeatroEntities().forEach(teatroEntity -> {
                        try {
                            teatroService.deleteById(teatroEntity.getId());
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!repository.findById(id).get().getTvEntities().isEmpty()) {
                    repository.findById(id).get().getTvEntities().forEach(tvEntity -> {
                        try {
                            tvService.deleteById(tvEntity.getId());
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                repository.deleteById(id);
            } else {
                throw new NotFoundException("Item not present");
            }
        } else {
            throw new NotFoundException("Item not found");
        }
    }
}
