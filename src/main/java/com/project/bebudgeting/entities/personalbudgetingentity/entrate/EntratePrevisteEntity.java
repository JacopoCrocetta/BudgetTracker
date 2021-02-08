package com.project.bebudgeting.entities.personalbudgetingentity.entrate;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.previste.*;
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
public class EntratePrevisteEntity {
    List<AltreCategorieEntratePrevisteEntity> altreCategorieEntities;
    List<BonusPrevisteEntity> bonusEntities;
    List<BustaPagaPrevisteEntity> bustaPagaEntities;
    List<InteressiPrevistoEntity> interessiEntities;
    List<RisparmiPrevistoEntity> risparmiEntities;
}
