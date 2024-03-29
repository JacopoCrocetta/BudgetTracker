package com.project.bebudgeting.entity.annuali.uscite;

import java.util.List;

import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.AltroRegaliEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.DonazioniBeneficenzaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettaglioregali.RegaliDBEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegaliUsciteEntity {
    private List<DonazioniBeneficenzaEntity> donazioniBeneficenzaEntities;
    private List<AltroRegaliEntity> altroEntities;
    private List<RegaliDBEntity> regaliDBEntities;
}