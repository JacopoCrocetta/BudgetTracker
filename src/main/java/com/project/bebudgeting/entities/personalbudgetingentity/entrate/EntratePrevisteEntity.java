package com.project.bebudgeting.entities.personalbudgetingentity.entrate;

import com.project.bebudgeting.entities.personalbudgetingentity.entrate.previste.*;
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
public class EntratePrevisteEntity {
    List<AltreCategorieEntratePrevisteEntity> altreCategorieEntities;
    List<BonusPrevistiEntity> bonusEntities;
    List<BustaPagaPrevisteEntity> bustaPagaEntities;
    List<InteressiPrevistiEntity> interessiEntities;
    List<RisparmiPrevistiEntity> risparmiEntities;
}
