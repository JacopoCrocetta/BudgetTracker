package com.project.bebudgeting.annuale.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.uscite.AltreUsciteEntity;
import com.project.bebudgeting.annuale.entity.uscite.AnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.AssicurazioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.BolletteEntity;
import com.project.bebudgeting.annuale.entity.uscite.CasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.DebitiEntity;
import com.project.bebudgeting.annuale.entity.uscite.DivertimentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.FigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.IstruzioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.RegaliEntity;
import com.project.bebudgeting.annuale.entity.uscite.SpeseMedicheEntity;
import com.project.bebudgeting.annuale.entity.uscite.SpeseQuotidianeEntity;
import com.project.bebudgeting.annuale.entity.uscite.TecnologiaEntity;
import com.project.bebudgeting.annuale.entity.uscite.ViaggiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.TrasportiEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UscitaAnnuale")
@Data
@NoArgsConstructor
@Getter
@Setter
public class UsciteAnnualiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "Altre_Uscite")
    private Set<AltreUsciteEntity> altreUsciteEntities;

    @OneToMany(mappedBy = "Animali_Domestici")
    private Set<AnimaliDomesticiEntity> animaliDomesticiEntities;

    @OneToMany(mappedBy = "Assicurazione")
    private Set<AssicurazioneEntity> assicurazioneEntities;

    @OneToMany(mappedBy = "Bollette")
    private Set<BolletteEntity> bolletteEntities;

    @OneToMany(mappedBy = "Casa")
    private Set<CasaEntity> casaEntities;

    @OneToMany(mappedBy = "Debiti")
    private Set<DebitiEntity> debitiEntities;

    @OneToMany(mappedBy = "Divertimento")
    private Set<DivertimentoEntity> divertimentoEntities;

    @OneToMany(mappedBy = "Figli")
    private Set<FigliEntity> figliEntities;

    @OneToMany(mappedBy = "Istruzione")
    private Set<IstruzioneEntity> istruzioneEntities;

    @OneToMany(mappedBy = "Regali")
    private Set<RegaliEntity> regaliEntities;

    @OneToMany(mappedBy = "Spese_Mediche")
    private Set<SpeseMedicheEntity> speseMedicheEntities;

    @OneToMany(mappedBy = "Spese_Quotiiane")
    private Set<SpeseQuotidianeEntity> speseQuotidianeEntities;

    @OneToMany(mappedBy = "Tecnologia")
    private Set<TecnologiaEntity> tecnologiaEntities;

    @OneToMany(mappedBy = "Trasporti")
    private Set<TrasportiEntity> trasportiEntities;

    @OneToMany(mappedBy = "Viaggi")
    private Set<ViaggiEntity> viaggiEntities;
}
