package com.project.bebudgeting.entities.personalbudgetingentity.entrate;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.effettive.*;
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
public class EntrateEffettiveEntity {
    List<AltreCategorieEntrateEffettiviEntity> altreCategorieEntities;
    List<BonusEffettiveEntity> bonusEntities;
    List<BustaPagaEffettiveEntity> bustaPagaEntities;
    List<InteressiEffettiviEntity> interessiEntities;
    List<RisparmiEffettiveEntity> risparmiEntities;
}
