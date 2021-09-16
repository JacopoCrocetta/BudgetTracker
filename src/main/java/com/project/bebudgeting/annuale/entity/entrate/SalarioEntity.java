package com.project.bebudgeting.annuale.entity.entrate;

import java.util.ArrayList;

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
    ArrayList<AltroSalarioEntity> altroSalarioEntity;
    ArrayList<BonusEntity> bonusEntity;
    ArrayList<BustaPagaEntity> bustaPagaEntity;
    ArrayList<CommissioniEntity> commissioniEntity;
    ArrayList<ManceEntity> manceEntity;
}
