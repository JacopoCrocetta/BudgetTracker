package com.project.bebudgeting.annuale.service.usciteservice;

import com.project.bebudgeting.annuale.entity.uscite.TecnologiaEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.TecnologiaRepository;
import com.project.bebudgeting.annuale.service.usciteservice.tecnologiaservice.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnologiaService {
    @Autowired
    TecnologiaRepository repository;

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

    public long count() {
        return repository.count();
    }

    // DELETE
    public void deleteAll() {
        altroTecnologiaService.deleteAll();
        hardwareService.deleteAll();
        hostingService.deleteAll();
        serviziOnlineService.deleteAll();
        softwareService.deleteAll();
        repository.deleteAll();
    }

    public void delete(TecnologiaEntity entity) throws NotFoundException {
        if (repository.existsById(entity.getId()) || repository.findById(entity.getId()).isPresent()) {
            if (!entity.getAltroEntities().isEmpty()) {
                entity.getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroTecnologiaService.delete(altroEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getHardwareEntities().isEmpty()) {
                entity.getHardwareEntities().forEach(hadrwareEntity -> {
                    try {
                        hardwareService.delete(hadrwareEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getHostingEntities().isEmpty()) {
                entity.getHostingEntities().forEach(hostingEntity -> {
                    try {
                        hostingService.delete(hostingEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getServiziOnlineEntities().isEmpty()) {
                entity.getServiziOnlineEntities().forEach(serviziEntity -> {
                    try {
                        serviziOnlineService.delete(serviziEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entity.getSoftwareEntities().isEmpty()) {
                entity.getSoftwareEntities().forEach(softwreEntity -> {
                    try {
                        softwareService.delete(softwreEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.delete(entity);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAll(Iterable<TecnologiaEntity> entities) {
        entities.forEach(entity -> {
            try {
                this.delete(entity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id) || repository.findById(id).isPresent()) {
            if (!repository.findById(id).get().getAltroEntities().isEmpty()) {
                repository.findById(id).get().getAltroEntities().forEach(entity -> {
                    try {
                        altroTecnologiaService.deleteById(entity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if(!repository.findById(id).get().getHardwareEntities().isEmpty()){
                repository.findById(id).get().getHardwareEntities().forEach(hardwareEntity -> {
                    try {
                        hardwareService.deleteById(hardwareEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if(!repository.findById(id).get().getHostingEntities().isEmpty()){
                repository.findById(id).get().getHostingEntities().forEach(hostingEntity -> {
                    try {
                        hostingService.deleteById(hostingEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if(!repository.findById(id).get().getServiziOnlineEntities().isEmpty()){
                repository.findById(id).get().getServiziOnlineEntities().forEach(serviziOnlineEntity -> {
                    try {
                        serviziOnlineService.deleteById(serviziOnlineEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if(!repository.findById(id).get().getSoftwareEntities().isEmpty()){
                repository.findById(id).get().getSoftwareEntities().forEach(softwareEntity -> {
                    try {
                        softwareService.deleteById(softwareEntity.getId());
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.deleteById(id);
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void deleteAllById(Iterable<Integer> ids){
        ids.forEach(integer -> {
            try {
                this.deleteById(integer);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    //FIND
    public Iterable<TecnologiaEntity> findAll(){
        return repository.findAll();
    }

    public Iterable<TecnologiaEntity> findAllById(Iterable<Integer> ids){
        return repository.findAllById(ids);
    }

    public Optional<TecnologiaEntity> findById(int id){
        return repository.findById(id);
    }
}
