package com.project.bebudgeting.annuale.service.usciteservice;

import java.util.Optional;

import com.project.bebudgeting.annuale.entity.uscite.DebitiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.DebitiRepository;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.AltriPrestitiService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.AltroService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.CarteCreditoService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.ImposteLocaliService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.ImposteStataliService;
import com.project.bebudgeting.annuale.service.usciteservice.debitiservice.PrestitiPerStudioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class DebitiService {
    @Autowired
    DebitiRepository repository;

    @Autowired
    AltriPrestitiService altriPrestitiService;

    @Autowired
    AltroService altroService;

    @Autowired
    CarteCreditoService carteCreditoService;

    @Autowired
    ImposteLocaliService imposteLocaliService;

    @Autowired
    ImposteStataliService imposteStataliService;

    @Autowired
    PrestitiPerStudioService prestitiPerStudioService;

    public long count() {
        return repository.count();
    }

    // DELETE
    public void delete(DebitiEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId())) {
            if (repository.findById(entity.getId()).isPresent()) {
                if (!entity.getAltriPrestitiEntities().isEmpty()) {
                    entity.getAltriPrestitiEntities().forEach(altriPrestitiEntity -> {
                        try {
                            altriPrestitiService.delete(altriPrestitiEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!entity.getAltroEntities().isEmpty()) {
                    entity.getAltroEntities().forEach(altroEntity -> {
                        try {
                            altroService.delete(altroEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!entity.getCarteCreditoEntities().isEmpty()) {
                    entity.getCarteCreditoEntities().forEach(carteCreditoEntity -> {
                        try {
                            carteCreditoService.delete(carteCreditoEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!entity.getImposteLocaliEntities().isEmpty()) {
                    entity.getImposteLocaliEntities().forEach(imposteLocaliEntity -> {
                        try {
                            imposteLocaliService.delete(imposteLocaliEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!entity.getImposteStataliEntities().isEmpty()) {
                    entity.getImposteStataliEntities().forEach(imposteStataliEntity -> {
                        try {
                            imposteStataliService.delete(imposteStataliEntity);
                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    });
                }
                if (!entity.getPrestitiPerStudiareEntities().isEmpty()) {
                    entity.getPrestitiPerStudiareEntities().forEach(prestitiStudioEntity -> {
                        try {
                            prestitiPerStudioService.delete(prestitiStudioEntity);
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

    public void deleteAll() {
        altriPrestitiService.deleteAll();
        altroService.deleteAll();
        carteCreditoService.deleteAll();
        imposteLocaliService.deleteAll();
        imposteStataliService.deleteAll();
        prestitiPerStudioService.deleteAll();
        repository.deleteAll();
    }

    public void deleteAll(Iterable<DebitiEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
        repository.deleteAll(entities);
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)||repository.findById(id).isPresent()) {
            if (!repository.findById(id).get().getAltriPrestitiEntities().isEmpty()) {
                repository.findById(id).get().getAltriPrestitiEntities().forEach(entity -> {
                    try {
                        altriPrestitiService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getAltroEntities().isEmpty()) {
                repository.findById(id).get().getAltroEntities().forEach(entity -> {
                    try {
                        altroService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getCarteCreditoEntities().isEmpty()) {
                repository.findById(id).get().getCarteCreditoEntities().forEach(entity -> {
                    try {
                        carteCreditoService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getImposteLocaliEntities().isEmpty()) {
                repository.findById(id).get().getImposteLocaliEntities().forEach(entity -> {
                    try {
                        imposteLocaliService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getImposteStataliEntities().isEmpty()) {
                repository.findById(id).get().getImposteStataliEntities().forEach(entity -> {
                    try {
                        imposteStataliService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!repository.findById(id).get().getPrestitiPerStudiareEntities().isEmpty()) {
                repository.findById(id).get().getPrestitiPerStudiareEntities().forEach(entity -> {
                    try {
                        prestitiPerStudioService.deleteById(entity.getId());
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
    public Iterable<DebitiEntity> findAll() {
        return repository.findAll();
    }

    public Iterable<DebitiEntity> findAllById(Iterable<Integer> ids) {
        return repository.findAllById(ids);
    }

    public Optional<DebitiEntity> findById(int id) {
        return repository.findById(id);
    }

    // SAVE
    public DebitiEntity save(DebitiEntity entity) {
        altriPrestitiService.saveAll(entity.getAltriPrestitiEntities());
        altroService.saveAll(entity.getAltroEntities());
        carteCreditoService.saveAll(entity.getCarteCreditoEntities());
        imposteLocaliService.saveAll(entity.getImposteLocaliEntities());
        imposteStataliService.saveAll(entity.getImposteStataliEntities());
        prestitiPerStudioService.saveAll(entity.getPrestitiPerStudiareEntities());
        return repository.save(entity);
    }

    public Iterable<DebitiEntity> saveAll(Iterable<DebitiEntity> entities) {
        entities.forEach(this::save);
        return entities;
    }
}
