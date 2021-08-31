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

import com.project.bebudgeting.mensile.entity.EntrateMensiliEntity;
import com.project.bebudgeting.mensile.entity.effettivi.entrate.AltreEntrateEffettiveEntity;
import com.project.bebudgeting.mensile.entity.effettivi.entrate.BonusEffettiviEntity;
import com.project.bebudgeting.mensile.entity.effettivi.entrate.BustaPagaEffettiveEntity;
import com.project.bebudgeting.mensile.entity.effettivi.entrate.InteressiEffettiviEntity;
import com.project.bebudgeting.mensile.entity.effettivi.entrate.RisparmiEffettiviEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entrate_mensili_effettive")
@Data
@NoArgsConstructor
@Getter
@Setter
public class EntrateEffettiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "identratemensile", insertable = false, updatable = false)
    private EntrateMensiliEntity entrateMensiliEntity;

    @OneToMany
    @JoinColumn(name = "identrataeffettiva")
    private Set<AltreEntrateEffettiveEntity> altreEntrateEffettiveEntities;

    @OneToMany
    @JoinColumn(name = "identrataeffettiva")
    private Set<BonusEffettiviEntity> bonusEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "identrataeffettiva")
    private Set<BustaPagaEffettiveEntity> bustaPagaEffettiveEntities;

    @OneToMany
    @JoinColumn(name = "identrataeffettiva")
    private Set<InteressiEffettiviEntity> interessiEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "identrataeffettiva")
    private Set<RisparmiEffettiviEntity> risparmiEffettiviEntities;
}
