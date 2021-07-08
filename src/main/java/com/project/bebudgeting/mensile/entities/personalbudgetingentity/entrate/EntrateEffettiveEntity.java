package com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.effettive.*;
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
public class EntrateEffettiveEntity {
    List<AltreCategorieEntrateEffettiviEntity> altreCategorieEntities;
    List<BonusEffettiveEntity> bonusEntities;
    List<BustaPagaEffettiveEntity> bustaPagaEntities;
    List<InteressiEffettiviEntity> interessiEntities;
    List<RisparmiEffettiveEntity> risparmiEntities;
}
