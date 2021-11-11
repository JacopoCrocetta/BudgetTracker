package com.project.bebudgeting.entity.annuali.uscite;

import java.util.List;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.AbbonamentiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.AltroSpeseQuotidianeEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.IgienePersonaleEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.LavanderiaEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.ParrucchiereEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.RistorantiEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.SupermercatoEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesequotidiane.VestitiSpeseQuotidianeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SpeseQuotidianeEntity {
    private List<AltroSpeseQuotidianeEntity> altroEntities;
    private List<AbbonamentiEntity> abbonamentiEntities;
    private List<IgienePersonaleEntity> igienePersonaleEntities;
    private List<LavanderiaEntity> lavanderiaEntities;
    private List<ParrucchiereEntity> parrucchiereEntities;
    private List<RistorantiEntity> ristorantiEntities;
    private List<SupermercatoEntity> supermercatoEntities;
    private List<VestitiSpeseQuotidianeEntity> vestitiEntities;
}