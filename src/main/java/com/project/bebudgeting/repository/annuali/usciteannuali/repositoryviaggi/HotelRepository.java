package com.project.bebudgeting.repository.annuali.usciteannuali.repositoryviaggi;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.HotelEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends CrudRepository<HotelEntity, Integer> {

}
