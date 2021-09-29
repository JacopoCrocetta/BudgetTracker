package com.project.bebudgeting.annuale.entity.uscite;

import java.util.List;

import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AlimentiAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AltroAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.FornitureAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.GiocattoliAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.VeterinarioAnimaliDomesticiEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnimaliDomesticiEntity {
    private List<AlimentiAnimaliDomesticiEntity> alimentiEntities;
    private List<AltroAnimaliDomesticiEntity> altroEntities;
    private List<FornitureAnimaliDomesticiEntity> fornitureEntities;
    private List<GiocattoliAnimaliDomesticiEntity> giocattoliEntity;
    private List<VeterinarioAnimaliDomesticiEntity> veterinarioEntities;
}