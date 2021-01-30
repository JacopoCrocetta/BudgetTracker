package com.project.BEbudgeting.entities.personalbudgetingentity;

import com.project.BEbudgeting.entities.personalbudgetingentity.entrate.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class EntrateEntity {
    AltreCategorieEntity altreCategorieEntity;
    BonusEntity bonusEntity;
    BustaPagaEntity bustaPagaEntity;
    InteressiEntity interessiEntity;
    RisparmiEntity risparmiEntity;
}
