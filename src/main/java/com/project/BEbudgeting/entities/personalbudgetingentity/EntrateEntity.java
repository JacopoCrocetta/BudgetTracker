package com.project.BEbudgeting.entities.personalbudgetingentity;

import com.project.BEbudgeting.entities.personalbudgetingentity.entrate.*;
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
public class EntrateEntity {
    List<AltreCategorieEntity> altreCategorieEntities;
    List<BonusEntity> bonusEntities;
    List<BustaPagaEntity> bustaPagaEntities;
    List<InteressiEntity> interessiEntities;
    List<RisparmiEntity> risparmiEntities;
}
