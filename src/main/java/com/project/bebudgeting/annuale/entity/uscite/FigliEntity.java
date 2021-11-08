package com.project.bebudgeting.annuale.entity.uscite;

import java.util.List;

import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AltroFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AsiloFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AttivitaFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.GiocattoliFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.PaghettaFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.ScuolaFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.SpeseMedicheFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.VestitiFigliEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FigliEntity {
    private List<AltroFigliEntity> altroFigliEntities;
    private List<AsiloFigliEntity> asiloEntities;
    private List<AttivitaFigliEntity> attivitaEntities;
    private List<GiocattoliFigliEntity> giocattoliEntities;
    private List<PaghettaFigliEntity> paghettaEntities;
    private List<ScuolaFigliEntity> scuolaEntities;
    private List<SpeseMedicheFigliEntity> speseMedicheFigliEntities;
    private List<VestitiFigliEntity> vestitiEntities;
}
