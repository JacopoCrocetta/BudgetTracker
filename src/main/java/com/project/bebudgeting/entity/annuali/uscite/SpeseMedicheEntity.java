package com.project.bebudgeting.entity.annuali.uscite;

import java.util.List;

import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.AltroSpeseMedicheEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.CureSpecialisticheEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.DottoriEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.EmergenzeEntity;
import com.project.bebudgeting.entity.annuali.uscite.dettagliospesemediche.FarmaciEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SpeseMedicheEntity {
    private List<CureSpecialisticheEntity> cureSpecialisticheEntities;
    private List<AltroSpeseMedicheEntity> altroEntities;
    private List<DottoriEntity> dottoriEntities;
    private List<EmergenzeEntity> emergenzeEntities;
    private List<FarmaciEntity> farmaciEntities;
}