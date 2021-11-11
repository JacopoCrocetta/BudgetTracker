package com.project.bebudgeting.entity.mensili.effettivi;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.entity.mensili.EntrateMensiliEntity;
import com.project.bebudgeting.entity.mensili.effettivi.entrate.AltreEntrateEffettiveEntity;
import com.project.bebudgeting.entity.mensili.effettivi.entrate.BonusEffettiviEntity;
import com.project.bebudgeting.entity.mensili.effettivi.entrate.BustaPagaEffettiveEntity;
import com.project.bebudgeting.entity.mensili.effettivi.entrate.InteressiEffettiviEntity;
import com.project.bebudgeting.entity.mensili.effettivi.entrate.RisparmiEffettiviEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entrate_mensili_effettive")

/**
 * @return boolean
 */

/**
 * @return boolean
 */

/**
 * @return int
 */

/**
 * @return String
 */

/**
 * @return boolean
 */

/**
 * @return boolean
 */

/**
 * @return int
 */

/**
 * @return String
 */
@Data
@NoArgsConstructor

/**
 * @return int
 */

/**
 * @return LocalDate
 */

/**
 * @return EntrateMensiliEntity
 */

/**
 * @return List<AltreEntrateEffettiveEntity>
 */

/**
 * @return List<BonusEffettiviEntity>
 */

/**
 * @return List<BustaPagaEffettiveEntity>
 */

/**
 * @return List<InteressiEffettiviEntity>
 */

/**
 * @return List<RisparmiEffettiviEntity>
 */

/**
 * @return int
 */

/**
 * @return LocalDate
 */

/**
 * @return EntrateMensiliEntity
 */

/**
 * @return List<AltreEntrateEffettiveEntity>
 */

/**
 * @return List<BonusEffettiviEntity>
 */

/**
 * @return List<BustaPagaEffettiveEntity>
 */

/**
 * @return List<InteressiEffettiviEntity>
 */

/**
 * @return List<RisparmiEffettiviEntity>
 */
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
    private List<AltreEntrateEffettiveEntity> altreEntrateEffettiveEntities;

    @OneToMany
    @JoinColumn(name = "identrataeffettiva")
    private List<BonusEffettiviEntity> bonusEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "identrataeffettiva")
    private List<BustaPagaEffettiveEntity> bustaPagaEffettiveEntities;

    @OneToMany
    @JoinColumn(name = "identrataeffettiva")
    private List<InteressiEffettiviEntity> interessiEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "identrataeffettiva")
    private List<RisparmiEffettiviEntity> risparmiEffettiviEntities;
}
