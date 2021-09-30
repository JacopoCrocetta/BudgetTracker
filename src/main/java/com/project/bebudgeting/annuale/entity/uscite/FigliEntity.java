package com.project.bebudgeting.annuale.entity.uscite;

import java.util.List;

import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AltroFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AsiloEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AttivitaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.GiocattoliFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.PaghettaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.ScuolaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.SpeseMedicheFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.VestitiFigliEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FigliEntity {
    private List<AltroFigliEntity> altroEntities;
    private List<AsiloEntity> asiloEntities;
    private List<AttivitaEntity> attivitaEntities;
    private List<GiocattoliFigliEntity> giocattoliEntities;
    private List<PaghettaEntity> paghettaEntities;
    private List<ScuolaEntity> scuolaEntities;
    private List<SpeseMedicheFigliEntity> speseMedicheFigliEntities;
    private List<VestitiFigliEntity> vestitiEntities;
}
