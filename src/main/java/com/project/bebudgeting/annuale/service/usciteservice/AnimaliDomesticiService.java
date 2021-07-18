package com.project.bebudgeting.annuale.service.usciteservice;

import com.project.bebudgeting.annuale.entity.uscite.AnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.repository.usciteannuali.AnimaliDomesticiRepository;
import com.project.bebudgeting.annuale.service.usciteservice.animalidomesticiservice.*;
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

    public long count(){
        return repository.count();
    }

    //DELETE
    public void delete(AnimaliDomesticiEntity entityToDelete) throws NotFoundException {
        if(repository.existsById(entityToDelete.getId())){
            if(!entityToDelete.getAlimentiEntities().isEmpty()){
                entityToDelete.getAlimentiEntities().forEach(alimentiEntity->{
                    try {
                        alimentiService.delete(alimentiEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if(!entityToDelete.getAltroEntities().isEmpty()){
                entityToDelete.getAltroEntities().forEach(altroEntity -> {
                    try {
                        altroAnimaliDomesticiService.delete(altroEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if(!entityToDelete.getFornitureEntities().isEmpty()){
                entityToDelete.getFornitureEntities().forEach(fornitureEntity -> {
                    try {
                        fornitureService.delete(fornitureEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if(!entityToDelete.getGiocattoliEntity().isEmpty()){
                entityToDelete.getGiocattoliEntity().forEach(giocattoliEntity -> {
                    try {
                        giocattoliService.delete(giocattoliEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            if (!entityToDelete.getVeterinarioEntities().isEmpty()){
                entityToDelete.getVeterinarioEntities().forEach(veterinarioEntity -> {
                    try {
                        veterinarioService.delete(veterinarioEntity);
                    } catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item Not Found");
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public void deleteAll(Iterable<AnimaliDomesticiEntity> entitiesToDelete){
        entitiesToDelete.forEach(entityToDelete -> {
            try {
                this.delete(entityToDelete);
            } catch (NotFoundException notFoundException) {
                notFoundException.printStackTrace();
            }
        });
    }

    public void deleteById(int id) throws NotFoundException {
        if (repository.existsById(id)){
            repository.findById(id).get().getAltroEntities();
            if(alimentiService.findById(id).isPresent()){
                alimentiService.deleteById(alimentiService.findById(id).get().getId());
            }
            if(altroAnimaliDomesticiService.findById(id).isPresent()){
                altroAnimaliDomesticiService.deleteById(altroAnimaliDomesticiService.findById(id).get().getId());
            }
            if(fornitureService.findById(id).isPresent()){
                fornitureService.deleteById(fornitureService.findById(id).get().getId());
            }
            if(giocattoliService.findById(id).isPresent()){
                giocattoliService.deleteById(giocattoliService.findById(id).get().getId());
            }
            if(veterinarioService.findById(id).isPresent()){
                veterinarioService.deleteById(veterinarioService.findById(id).get().getId());
            }
            repository.deleteById(id);
        }

    }
}
