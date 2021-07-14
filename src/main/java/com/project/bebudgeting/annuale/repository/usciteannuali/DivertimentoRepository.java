package com.project.bebudgeting.annuale.repository.usciteannuali;

import org.springframework.data.repository.CrudRepository;
import com.project.bebudgeting.annuale.entity.uscite.DivertimentoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DivertimentoRepository extends CrudRepository<DivertimentoEntity, Integer> {

}
