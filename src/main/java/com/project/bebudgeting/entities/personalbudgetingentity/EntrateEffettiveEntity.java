package com.project.bebudgeting.entities.personalbudgetingentity;

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
    List<AltreCategorieEffettiveEntity> altreCategorieEntities;
    List<BonusEffettiveEntity> bonusEntities;
    List<BustaPagaEffettiveEntity> bustaPagaEntities;
    List<InteressiEffettivoEntity> interessiEntities;
    List<RisparmiEffettiveEntity> risparmiEntities;
}
