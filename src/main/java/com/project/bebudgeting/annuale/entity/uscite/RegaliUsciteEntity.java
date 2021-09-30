package com.project.bebudgeting.annuale.entity.uscite;

import java.util.List;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioregali.AltroRegaliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioregali.DonazioniBeneficenzaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioregali.RegaliDBEntity;

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