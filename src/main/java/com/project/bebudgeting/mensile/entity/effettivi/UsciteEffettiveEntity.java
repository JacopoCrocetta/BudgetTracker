package com.project.bebudgeting.mensile.entity.effettivi;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.mensile.entity.effettivi.uscite.AlimentiEffettiviEntity;
import com.project.bebudgeting.mensile.entity.effettivi.uscite.AltreUsciteEffettiveEntity;
import com.project.bebudgeting.mensile.entity.effettivi.uscite.AnimaliDomesticiEffettiviEntity;
import com.project.bebudgeting.mensile.entity.effettivi.uscite.BolletteEffettiviEntity;
import com.project.bebudgeting.mensile.entity.effettivi.uscite.CasaEffettiviEntity;
import com.project.bebudgeting.mensile.entity.effettivi.uscite.DebitiEffettiviEntity;
import com.project.bebudgeting.mensile.entity.effettivi.uscite.RegaliEffettiviEntity;
import com.project.bebudgeting.mensile.entity.effettivi.uscite.SpeseMedicheEffettiviEntity;
import com.project.bebudgeting.mensile.entity.effettivi.uscite.SpesePersonaliEffettiviEntity;
import com.project.bebudgeting.mensile.entity.effettivi.uscite.TrasportiEffettiviEntity;
import com.project.bebudgeting.mensile.entity.effettivi.uscite.ViaggiEffettiviEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Uscita_Effettive")
@Data
@NoArgsConstructor
@Getter
@Setter
public class UsciteEffettiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @OneToMany(mappedBy = "AlimentiEffettiviEntity")
    private Set<AlimentiEffettiviEntity> alimentiEffettiviEntities;

    @OneToMany(mappedBy = "AltreUsciteEffettiveEntity")
    private Set<AltreUsciteEffettiveEntity> altreUsciteEffettiveEntities;

    @OneToMany(mappedBy = "AnimaliDomesticiEffettiviEntity")
    private Set<AnimaliDomesticiEffettiviEntity> animaliDomesticiEffettiviEntities;

    @OneToMany(mappedBy = "BolletteEffettiviEntity")
    private Set<BolletteEffettiviEntity> bolletteEffettiviEntities;

    @OneToMany(mappedBy = "CasaEffettiviEntity")
    private Set<CasaEffettiviEntity> casaEffettiviEntities;

    @OneToMany(mappedBy = "DebitiEffettiviEntity")
    private Set<DebitiEffettiviEntity> debitiEffettiviEntities;

    @OneToMany(mappedBy = "RegaliEffettiviEntity")
    private Set<RegaliEffettiviEntity> regaliEffettiviEntities;

    @OneToMany(mappedBy = "SpeseMedicheEffettiviEntity")
    private Set<SpeseMedicheEffettiviEntity> speseMedicheEffettiviEntities;

    @OneToMany(mappedBy = "SpesePersonaliEffettiviEntity")
    private Set<SpesePersonaliEffettiviEntity> spesePersonaliEffettiviEntities;

    @OneToMany(mappedBy = "TrasportiEffettiviEntity")
    private Set<TrasportiEffettiviEntity> trasportiEffettiviEntities;

    @OneToMany(mappedBy = "ViaggiEffettiviEntity")
    private Set<ViaggiEffettiviEntity> viaggiEffettiviEntities;
}
