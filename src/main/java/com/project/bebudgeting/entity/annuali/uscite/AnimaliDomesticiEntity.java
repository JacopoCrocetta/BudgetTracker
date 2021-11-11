package com.project.bebudgeting.entity.annuali.uscite;

import java.util.List;

import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.AlimentiAnimaliDomesticiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.AltroAnimaliDomesticiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.FornitureAnimaliDomesticiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.GiocattoliAnimaliDomesticiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici.VeterinarioAnimaliDomesticiEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * @return List<AlimentiAnimaliDomesticiEntity>
 */

/** 
 * @return List<AltroAnimaliDomesticiEntity>
 */

/** 
 * @return List<FornitureAnimaliDomesticiEntity>
 */

/** 
 * @return List<GiocattoliAnimaliDomesticiEntity>
 */

/**
 * @return List<VeterinarioAnimaliDomesticiEntity>
 */

/** 
 * @return List<AlimentiAnimaliDomesticiEntity>
 */

/** 
 * @return List<AltroAnimaliDomesticiEntity>
 */

/** 
 * @return List<FornitureAnimaliDomesticiEntity>
 */

/** 
 * @return List<GiocattoliAnimaliDomesticiEntity>
 */

/**
 * @return List<VeterinarioAnimaliDomesticiEntity>
 */
@Getter
@Setter
@NoArgsConstructor
public class AnimaliDomesticiEntity {
    private List<AlimentiAnimaliDomesticiEntity> alimentiEntities;
    private List<AltroAnimaliDomesticiEntity> altroEntities;
    private List<FornitureAnimaliDomesticiEntity> fornitureEntities;
    private List<GiocattoliAnimaliDomesticiEntity> giocattoliEntities;
    private List<VeterinarioAnimaliDomesticiEntity> veterinarioEntities;
}