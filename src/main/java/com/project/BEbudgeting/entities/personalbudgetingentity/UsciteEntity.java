package com.project.BEbudgeting.entities.personalbudgetingentity;

import com.project.BEbudgeting.entities.personalbudgetingentity.uscite.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class UsciteEntity {
    List<AlimentiEntity> alimentiEntity;
    List<AltreCategorieEntity> altreCategorieEntity;
    List<AnimaliDomesticiEntity> animaliDomesticiEntity;
    List<BolletteEntity> bolletteEntity;
    List<CasaEntity> casaEntity;
    List<DebitiEntity> debitiEntity;
    List<InvestimentiEntity> investimentiEntity;
    List<RegaliEntity> regaliEntity;
    List<SaluteEntity> saluteEntity;
    List<SpesePersonaliEntity> spesePersonaliEntity;
}
