package com.project.bebudgeting.annuale.entity.uscite;

import java.util.List;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.AltroTrasportiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.BolloEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.CarburanteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.FornitureTrasportiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.PrestitoAutoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.RiparazioniEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.TrasportoPubblicoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrasportiUsciteEntity {
    private List<BolloEntity> bolloEntities;
    private List<AltroTrasportiEntity> altroEntities;
    private List<CarburanteEntity> carburanteEntities;
    private List<FornitureTrasportiEntity> fornitureEntities;
    private List<PrestitoAutoEntity> prestitoAutoEntities;
    private List<RiparazioniEntity> riparazioniEntities;
    private List<TrasportoPubblicoEntity> trasportoPubblicoEntities;
}