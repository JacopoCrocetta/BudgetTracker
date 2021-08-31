package com.project.bebudgeting.annuale.entity;

import java.time.LocalDate;
import java.util.Set;

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
import com.project.bebudgeting.annuale.entity.uscite.ViaggiEntity;
import com.project.bebudgeting.annuale.entity.uscite.TrasportiUsciteEntity;

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
    private Set<AltreUsciteEntity> altreUsciteEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<AnimaliDomesticiEntity> animaliDomesticiEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<AssicurazioneEntity> assicurazioneEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<BolletteEntity> bolletteEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<CasaEntity> casaEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<DebitiEntity> debitiEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<DivertimentoUsciteEntity> divertimentoEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<FigliEntity> figliEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<IstruzioneEntity> istruzioneEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<RegaliUsciteEntity> regaliEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<SpeseMedicheEntity> speseMedicheEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<SpeseQuotidianeEntity> speseQuotidianeEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<TecnologiaEntity> tecnologiaEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<TrasportiUsciteEntity> trasportiEntities;

    @OneToMany
    @JoinColumn(name = "iduscita")
    private Set<ViaggiEntity> viaggiEntities;
}
