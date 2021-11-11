package com.project.bebudgeting.entity.annuali.uscite;

import java.util.List;

import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.AltriPrestitiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.AltroDebitiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.CarteCreditoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.ImposteLocaliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.ImposteStataliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliodebiti.PrestitiPerStudiareEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * @return List<AltriPrestitiEntity>
 */

/** 
 * @return List<AltroDebitiEntity>
 */

/** 
 * @return List<CarteCreditoEntity>
 */

/** 
 * @return List<ImposteLocaliEntity>
 */

/** 
 * @return List<ImposteStataliEntity>
 */

/**
 * @return List<PrestitiPerStudiareEntity>
 */

/** 
 * @return List<AltriPrestitiEntity>
 */

/** 
 * @return List<AltroDebitiEntity>
 */

/** 
 * @return List<CarteCreditoEntity>
 */

/** 
 * @return List<ImposteLocaliEntity>
 */

/** 
 * @return List<ImposteStataliEntity>
 */

/**
 * @return List<PrestitiPerStudiareEntity>
 */
@Getter
@Setter
@NoArgsConstructor
public class DebitiEntity {
    private List<AltriPrestitiEntity> altriPrestitiEntities;
    private List<AltroDebitiEntity> altroEntities;
    private List<CarteCreditoEntity> carteCreditoEntities;
    private List<ImposteLocaliEntity> imposteLocaliEntities;
    private List<ImposteStataliEntity> imposteStataliEntities;
    private List<PrestitiPerStudiareEntity> prestitiPerStudiareEntities;
}