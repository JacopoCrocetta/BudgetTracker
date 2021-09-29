package com.project.bebudgeting.annuale.entity.uscite;

import java.util.List;

import javax.persistence.Entity;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.AltriPrestitiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.AltroDebitiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.CarteCreditoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.ImposteLocaliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.ImposteStataliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.PrestitiPerStudiareEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
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