package com.project.bebudgeting.annuale.repository.entrateannuali;

import com.project.bebudgeting.annuale.entity.entrate.SalarioEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarioRepository extends CrudRepository<SalarioEntity, Integer> {
}
