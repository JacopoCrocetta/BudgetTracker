package com.project.bebudgeting.annuale.entity.uscite;

import java.util.List;

import javax.persistence.Entity;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneSaluteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AssicurazioneEntity {
    private List<AltreAssicurazioniEntity> altreAssicurazioniEntities;
    private List<AssicurazioneAutoEntity> assicurazioneAutoEntities;
    private List<AssicurazioneCasaEntity> assicurazioneCasaEntities;
    private List<AssicurazioneSaluteEntity> assicurazioneSaluteEntities;
    private List<AssicurazioneVitaEntity> assicurazioneVitaEntities;
}