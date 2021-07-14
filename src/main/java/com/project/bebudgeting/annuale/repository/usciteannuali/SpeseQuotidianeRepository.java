package com.project.bebudgeting.annuale.repository.usciteannuali;

import com.project.bebudgeting.annuale.entity.uscite.SpeseQuotidianeEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeseQuotidianeRepository extends CrudRepository<SpeseQuotidianeEntity, Integer> {

}
