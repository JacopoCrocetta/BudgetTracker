package com.project.bebudgeting.annuale.entity.uscite;

import java.util.List;

import javax.persistence.Entity;

import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.AltroDivertimentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.AttivitaOutsideEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.ConcertiOSpettacoliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.FilmEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.FotografiaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.HobbyEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.LibriDivertimentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.MusicaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.PartiteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.SportEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.TVEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.TeatroEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DivertimentoUsciteEntity {
    private List<AltroDivertimentoEntity> altroEntities;
    private List<AttivitaOutsideEntity> attivitaOutsideEntities;
    private List<ConcertiOSpettacoliEntity> concertiOSpettacoliEntities;
    private List<FilmEntity> filmEntities;
    private List<FotografiaEntity> fotografiaEntities;
    private List<HobbyEntity> hobbyEntities;
    private List<LibriDivertimentoEntity> libriEntities;
    private List<MusicaEntity> musicaEntities;
    private List<PartiteEntity> partiteEntities;
    private List<SportEntity> sportEntities;
    private List<TeatroEntity> teatroEntities;
    private List<TVEntity> tvEntities;
}