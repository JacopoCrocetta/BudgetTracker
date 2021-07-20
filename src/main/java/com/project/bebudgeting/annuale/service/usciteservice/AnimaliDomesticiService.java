package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.AnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.AnimaliDomesticiRepository;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.AlimentiService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.AltroAnimaliDomesticiService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.FornitureService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.GiocattoliService;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.VeterinarioService;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimaliDomesticiService {
    @Autowired
    AnimaliDomesticiRepository repository;

    @Autowired
    AlimentiService alimentiService;

    @Autowired
    AltroAnimaliDomesticiService altroAnimaliDomesticiService;

    @Autowired
    FornitureService fornitureService;

    @Autowired
    GiocattoliService giocattoliService;

    @Autowired
    VeterinarioService veterinarioService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(AnimaliDomesticiEntity entityToDelete) throws NotFoundException {
        if (repository.existsById(entityToDelete.getId())) {
            if (!entityToDelete.getAlimentiEntities().isEmpty()) {
                entityToDelete.getAlimentiEntities().forEach(alimentiEntity -> {
                    try {
                        alimentiService.delete(alimentiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entityToDelete.getAltroEntities().isEmpty()) {
                entityToDelete.getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroAnimaliDomesticiService.delete(altroEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entityToDelete.getFornitureEntities().isEmpty()) {
                entityToDelete.getFornitureEntities().forEach(fornitureEntity -> {
                    try {
                        fornitureService.delete(fornitureEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entityToDelete.getGiocattoliEntity().isEmpty()) {
                entityToDelete.getGiocattoliEntity().forEach(giocattoliEntity -> {
                    try {
                        giocattoliService.delete(giocattoliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entityToDelete.getVeterinarioEntities().isEmpty()) {
                entityToDelete.getVeterinarioEntities().forEach(veterinarioEntity -> {
                    try {
                        veterinarioService.delete(veterinarioEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.delete(entityToDelete);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AnimaliDomesticiEntity> entitiesToDelete) {
        entitiesToDelete.forEach(entityToDelete -> {
            try {
                this.delete(entityToDelete);
            } catch (NotFoundException notFoundException) {
                notFoundException.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)) {
            if (!repository.findById(id).get().getAltroEntities().isEmpty()) {
                repository.findById(id).get().getAltroEntities().forEach(entity -> {
                    try {
                        altroAnimaliDomesticiService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getAlimentiEntities().isEmpty()) {
                repository.findById(id).get().getAlimentiEntities().forEach(entity -> {
                    try {
                        altroAnimaliDomesticiService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getFornitureEntities().isEmpty()) {
                repository.findById(id).get().getFornitureEntities().forEach(entity -> {
                    try {
                        altroAnimaliDomesticiService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getGiocattoliEntity().isEmpty()) {
                repository.findById(id).get().getGiocattoliEntity().forEach(entity -> {
                    try {
                        altroAnimaliDomesticiService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getVeterinarioEntities().isEmpty()) {
                repository.findById(id).get().getVeterinarioEntities().forEach(entity -> {
                    try {
                        altroAnimaliDomesticiService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item Not Found");
        }
    }

    public void deleteAllById(Iterable<Integer> ids) {
        ids.forEach(id -> {
            try {
                this.deleteById(id);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    // FIND
    public Iterable<AnimaliDomesticiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<AnimaliDomesticiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<AnimaliDomesticiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public AnimaliDomesticiEntity save(AnimaliDomesticiEntity entityToSave) {
        if (!entityToSave.getAlimentiEntities().isEmpty()) {
            entityToSave.getAlimentiEntities().forEach(entity -> {
                if (!alimentiService.findById(entity.getId()).isPresent()) {
                    alimentiService.save(entity);
                }
            });
        }
        if (!entityToSave.getAltroEntities().isEmpty()) {
            entityToSave.getAltroEntities().forEach(entity -> {
                if (!altroAnimaliDomesticiService.findById(entity.getId()).isPresent()) {
                    altroAnimaliDomesticiService.save(entity);
                }
            });
        }
        if (!entityToSave.getFornitureEntities().isEmpty()) {
            entityToSave.getFornitureEntities().forEach(entity -> {
                if (!fornitureService.findById(entity.getId()).isPresent()) {
                    fornitureService.save(entity);
                }
            });
        }
        if (!entityToSave.getGiocattoliEntity().isEmpty()) {
            entityToSave.getGiocattoliEntity().forEach(entity -> {
                if (!giocattoliService.findById(entity.getId()).isPresent()) {
                    giocattoliService.save(entity);
                }
            });
        }
        if (!entityToSave.getVeterinarioEntities().isEmpty()) {
            entityToSave.getVeterinarioEntities().forEach(entity -> {
                if (!veterinarioService.findById(entity.getId()).isPresent()) {
                    veterinarioService.save(entity);
                }
            });
        }
        return repository.save(entityToSave);
    }

    public Iterable<AnimaliDomesticiEntity> saveAll(Iterable<AnimaliDomesticiEntity> entitiesToSave) {
        entitiesToSave.forEach(entity -> {
            this.save(entity);
        });
        return entitiesToSave;
    }
}
