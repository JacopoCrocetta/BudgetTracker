package com.project.bebudgeting.entities.personalbudgetingentity.uscite;

import com.project.bebudgeting.entities.personalbudgetingentity.uscite.effettive.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.List;

@Embeddable
@Data
@NoArgsConstructor
@Getter
@Setter
public class UsciteEffettiveEntity {
    List<AlimentiEffettiviEntity> alimentiEffettiviEntity;
    List<AltreCategorieUsciteEffettiveEntity> altreCategorieUsciteEffettiveEntity;
    List<AnimaliDomesticiEffettiveEntity> animaliDomesticiEffettiveEntity;
    List<BolletteEffettiviEntity> bolletteEffettiviEntity;
    List<CasaEffettiveEntity> casaEffettiveEntity;
    List<DebitiEffettiviEntity> debitiEffettiviEntity;
    List<InvestimentiEffettiviEntity> investimentiEffettiviEntity;
    List<RegaliEffettiviEntity> regaliEffettiviEntity;
    List<SaluteEffettiveEntity> saluteEffettiveEntity;
    List<SpesePersonaliEffettiveEntity> spesePersonaliEffettiveEntity;
}
