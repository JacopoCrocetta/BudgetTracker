package com.project.bebudgeting.mensile.entity.effettivi;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.mensile.entity.UsciteMensiliEntity;
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
@Table(name = "uscite_mensili_effettive")
@Data
@NoArgsConstructor
@Getter
@Setter
public class UsciteEffettiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "iduscitemensile", insertable = false, updatable = false)
    private UsciteMensiliEntity usciteMensiliEntity;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private Set<AlimentiEffettiviEntity> alimentiEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private Set<AltreUsciteEffettiveEntity> altreUsciteEffettiveEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private Set<AnimaliDomesticiEffettiviEntity> animaliDomesticiEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private Set<BolletteEffettiviEntity> bolletteEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private Set<CasaEffettiviEntity> casaEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private Set<DebitiEffettiviEntity> debitiEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private Set<RegaliEffettiviEntity> regaliEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private Set<SpeseMedicheEffettiviEntity> speseMedicheEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private Set<SpesePersonaliEffettiviEntity> spesePersonaliEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private Set<TrasportiEffettiviEntity> trasportiEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private Set<ViaggiEffettiviEntity> viaggiEffettiviEntities;
}
