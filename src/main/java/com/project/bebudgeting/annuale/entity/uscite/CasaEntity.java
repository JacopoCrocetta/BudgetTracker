package com.project.bebudgeting.annuale.entity.uscite;

import java.util.List;

import javax.persistence.Entity;

import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.AffittoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.AltroCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ArredamentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.FornitureCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.GiardinaggioEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ImposteImmobiliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ManutenzioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.MiglioramentiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.TraslocoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CasaEntity {
    private List<AffittoEntity> affittoEntities;
    private List<AltroCasaEntity> altroEntities;
    private List<ArredamentoEntity> arredamentoEntities;
    private List<FornitureCasaEntity> fornitureEntities;
    private List<GiardinaggioEntity> giardinaggioEntities;
    private List<ImposteImmobiliEntity> imposteImmobiliEntities;
    private List<ManutenzioneEntity> manutenzioneEntities;
    private List<MiglioramentiEntity> miglioramentiEntities;
    private List<TraslocoEntity> traslocoEntities;
}