package com.project.bebudgeting.entities.personalbudgetingentity.entrate;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.effettive.*;
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
public class EntrateEffettiveEntity {
    List<AltreCategorieEntrateEffettiveEntity> altreCategorieEntities;
    List<BonusEffettiveEntity> bonusEntities;
    List<BustaPagaEffettiveEntity> bustaPagaEntities;
    List<InteressiEffettivoEntity> interessiEntities;
    List<RisparmiEffettiveEntity> risparmiEntities;
}
