package com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.effettive.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
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
