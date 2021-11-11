package com.project.bebudgeting.entity.annuali.uscite;

import java.util.List;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.AlimentiViaggiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.AltroViaggiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.BigliettiAereiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.DivertimentoViaggiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.HotelEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioviaggi.TrasportiViaggiEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * @return List<AlimentiViaggiEntity>
 */

/** 
 * @return List<AltroViaggiEntity>
 */

/** 
 * @return List<BigliettiAereiEntity>
 */

/** 
 * @return List<DivertimentoViaggiEntity>
 */

/** 
 * @return List<HotelEntity>
 */

/**
 * @return List<TrasportiViaggiEntity>
 */

/** 
 * @return List<AlimentiViaggiEntity>
 */

/** 
 * @return List<AltroViaggiEntity>
 */

/** 
 * @return List<BigliettiAereiEntity>
 */

/** 
 * @return List<DivertimentoViaggiEntity>
 */

/** 
 * @return List<HotelEntity>
 */

/**
 * @return List<TrasportiViaggiEntity>
 */
@Getter
@Setter
@NoArgsConstructor
public class ViaggiEntity {
    private List<AlimentiViaggiEntity> alimentiEntities;
    private List<AltroViaggiEntity> altroEntities;
    private List<BigliettiAereiEntity> bigliettiAereiEntities;
    private List<DivertimentoViaggiEntity> divertimentoEntities;
    private List<HotelEntity> hotelEntities;
    private List<TrasportiViaggiEntity> trasportiEntities;
}