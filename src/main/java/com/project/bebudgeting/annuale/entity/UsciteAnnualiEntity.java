package com.project.bebudgeting.annuale.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.uscite.AltreUsciteEntity;
import com.project.bebudgeting.annuale.entity.uscite.AnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.AssicurazioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.BolletteEntity;
import com.project.bebudgeting.annuale.entity.uscite.CasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.DebitiEntity;
import com.project.bebudgeting.annuale.entity.uscite.DivertimentoUsciteEntity;
import com.project.bebudgeting.annuale.entity.uscite.FigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.IstruzioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.RegaliUsciteEntity;
import com.project.bebudgeting.annuale.entity.uscite.SpeseMedicheEntity;
import com.project.bebudgeting.annuale.entity.uscite.SpeseQuotidianeEntity;
import com.project.bebudgeting.annuale.entity.uscite.TecnologiaEntity;
import com.project.bebudgeting.annuale.entity.uscite.TrasportiUsciteEntity;
import com.project.bebudgeting.annuale.entity.uscite.ViaggiEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "uscite_annuali")
@Data
@NoArgsConstructor
@Getter
@Setter
public class UsciteAnnualiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<AltreUsciteEntity> altreUsciteEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<AnimaliDomesticiEntity> animaliDomesticiEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<AssicurazioneEntity> assicurazioneEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<BolletteEntity> bolletteEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<CasaEntity> casaEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<DebitiEntity> debitiEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<DivertimentoUsciteEntity> divertimentoEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<FigliEntity> figliEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<IstruzioneEntity> istruzioneEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<RegaliUsciteEntity> regaliEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<SpeseMedicheEntity> speseMedicheEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<SpeseQuotidianeEntity> speseQuotidianeEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<TecnologiaEntity> tecnologiaEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<TrasportiUsciteEntity> trasportiEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private List<ViaggiEntity> viaggiEntities;
}
