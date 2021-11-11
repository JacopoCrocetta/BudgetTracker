package com.project.bebudgeting.entity.annuali.uscite;

import java.util.List;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneCasaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneSaluteEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * @return List<AltreAssicurazioniEntity>
 */

/** 
 * @return List<AssicurazioneAutoEntity>
 */

/** 
 * @return List<AssicurazioneCasaEntity>
 */

/** 
 * @return List<AssicurazioneSaluteEntity>
 */

/**
 * @return List<AssicurazioneVitaEntity>
 */

/** 
 * @return List<AltreAssicurazioniEntity>
 */

/** 
 * @return List<AssicurazioneAutoEntity>
 */

/** 
 * @return List<AssicurazioneCasaEntity>
 */

/** 
 * @return List<AssicurazioneSaluteEntity>
 */

/**
 * @return List<AssicurazioneVitaEntity>
 */
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