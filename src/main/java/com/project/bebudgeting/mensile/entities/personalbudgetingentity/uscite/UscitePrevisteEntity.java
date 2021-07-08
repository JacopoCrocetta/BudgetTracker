package com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.previste.*;
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
public class UscitePrevisteEntity {
    List<AlimentiPrevistiEntity> alimentiEffettiviEntity;
    List<AltreCategorieUscitePrevisteEntity> altreCategorieUsciteEffettiveEntity;
    List<AnimaliDomesticiPrevisteEntity> animaliDomesticiEffettiveEntity;
    List<BollettePrevistiEntity> bolletteEffettiviEntity;
    List<CasaPrevisteEntity> casaEffettiveEntity;
    List<DebitiPrevistiEntity> debitiEffettiviEntity;
    List<InvestimentiPrevistiEntity> investimentiEffettiviEntity;
    List<RegaliPrevistiEntity> regaliEffettiviEntity;
    List<SalutePrevistiEntity> saluteEffettiveEntity;
    List<SpesePersonaliPrevistiEntity> spesePersonaliEffettiveEntity;
}
