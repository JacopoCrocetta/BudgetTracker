package com.project.bebudgeting.annuale.entity.uscite;

import java.util.List;

import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.AltreBolletteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteAcquaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteElettricitaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteGASEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteInternetEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteRifiutiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteTVEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteTelefonoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BolletteEntity {
    private List<AltreBolletteEntity> altreBolletteEntities;
    private List<BolletteAcquaEntity> bolletteAcquaEntities;
    private List<BolletteElettricitaEntity> bolletteElettricitaEntities;
    private List<BolletteGASEntity> bolletteGASEntities;
    private List<BolletteInternetEntity> bolletteInternetEntities;
    private List<BolletteRifiutiEntity> bolletteRifiutiEntities;
    private List<BolletteTelefonoEntity> bolletteTelefonoEntities;
    private List<BolletteTVEntity> bolletteTVEntities;
}