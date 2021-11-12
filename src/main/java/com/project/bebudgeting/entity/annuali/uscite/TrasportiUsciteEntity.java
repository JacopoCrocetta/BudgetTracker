package com.project.bebudgeting.entity.annuali.uscite;

import java.util.List;

import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.AltroTrasportiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.BolloEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.CarburanteEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.FornitureTrasportiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.PrestitoAutoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.RiparazioniEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliotrasporti.TrasportoPubblicoEntity;

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