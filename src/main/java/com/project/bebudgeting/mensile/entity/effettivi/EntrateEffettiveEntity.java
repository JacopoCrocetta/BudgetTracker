package com.project.bebudgeting.mensile.entity.effettivi;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "Entrate_Effettive")
@Data
@NoArgsConstructor
@Getter
@Setter
public class EntrateEffettiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @OneToMany(mappedBy = "AltreEntrateEffettiveEntity")
    private Set<AltreEntrateEffettiveEntity> altreEntrateEffettiveEntities;

    @OneToMany(mappedBy = "BonusEffettiviEntity")
    private Set<BonusEffettiviEntity> bonusEffettiviEntities;

    @OneToMany(mappedBy = "BustaPagaEffettiveEntity")
    private Set<BustaPagaEffettiveEntity> bustaPagaEffettiveEntities;

    @OneToMany(mappedBy = "InteressiEffettiviEntity")
    private Set<InteressiEffettiviEntity> interessiEffettiviEntities;

    @OneToMany(mappedBy = "RisparmiEffettiviEntity")
    private Set<RisparmiEffettiviEntity> risparmiEffettiviEntities;
}
