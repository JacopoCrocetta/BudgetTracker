package com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate;

import com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.previste.*;
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
public class EntratePrevisteEntity {
    List<AltreCategorieEntratePrevisteEntity> altreCategorieEntities;
    List<BonusPrevistiEntity> bonusEntities;
    List<BustaPagaPrevisteEntity> bustaPagaEntities;
    List<InteressiPrevistiEntity> interessiEntities;
    List<RisparmiPrevistiEntity> risparmiEntities;
}
