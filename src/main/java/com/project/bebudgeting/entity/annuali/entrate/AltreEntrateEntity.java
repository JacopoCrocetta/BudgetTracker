package com.project.bebudgeting.entity.annuali.entrate;

import java.util.List;

import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.AltroAltreEntrateEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.DividendiEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.InteressiEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.RegaliAltreEntrateEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.RimborsiEntity;
import com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate.TrasferimentoRisparmiEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AltreEntrateEntity {
    private List<AltroAltreEntrateEntity> altroEntities;
    private List<DividendiEntity> dividendiEntities;
    private List<InteressiEntity> interessiEntities;
    private List<RegaliAltreEntrateEntity> regaliEntities;
    private List<RimborsiEntity> rimborsiEntities;
    private List<TrasferimentoRisparmiEntity> trasferimentoRisparmiEntities;
}
