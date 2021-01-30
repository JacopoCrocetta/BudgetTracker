package com.project.BEbudgeting.entities.personalbudgetingentity;

import com.project.BEbudgeting.entities.personalbudgetingentity.uscite.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class UsciteEntity {
    AlimentiEntity alimentiEntity;
    AltreCategorieEntity altreCategorieEntity;
    AnimaliDomestici animaliDomestici;
    BolletteEntity bolletteEntity;
    CasaEntity casaEntity;
    DebitiEntity debitiEntity;
    InvestimentiEntity investimentiEntity;
    RegaliEntity regaliEntity;
    SaluteEntity saluteEntity;
    SpesePersonaliEntity spesePersonaliEntity;
}
