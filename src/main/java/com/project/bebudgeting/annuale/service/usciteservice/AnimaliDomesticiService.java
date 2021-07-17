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
            repository.delete(entityToDelete);
        }
        throw new NotFoundException("Item Not Found");
    }
}
