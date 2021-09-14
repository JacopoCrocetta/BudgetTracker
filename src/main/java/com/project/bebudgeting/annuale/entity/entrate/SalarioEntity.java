package com.project.bebudgeting.annuale.entity.entrate;

import java.util.List;

import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.AltroSalarioEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.BonusEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.BustaPagaEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.CommissioniEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.ManceEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class SalarioEntity {
    List<AltroSalarioEntity> altroSalarioEntity;
    List<BonusEntity> bonusEntity;
    List<BustaPagaEntity> bustaPagaEntity;
    List<CommissioniEntity> commissioniEntity;
    List<ManceEntity> manceEntity;
}
