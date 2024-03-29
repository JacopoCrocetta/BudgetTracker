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

import com.project.bebudgeting.entity.mensili.UsciteMensiliEntity;
import com.project.bebudgeting.entity.mensili.effettivi.uscite.AlimentiEffettiviEntity;
import com.project.bebudgeting.entity.mensili.effettivi.uscite.AltreUsciteEffettiveEntity;
import com.project.bebudgeting.entity.mensili.effettivi.uscite.AnimaliDomesticiEffettiviEntity;
import com.project.bebudgeting.entity.mensili.effettivi.uscite.BolletteEffettiviEntity;
import com.project.bebudgeting.entity.mensili.effettivi.uscite.CasaEffettiviEntity;
import com.project.bebudgeting.entity.mensili.effettivi.uscite.DebitiEffettiviEntity;
import com.project.bebudgeting.entity.mensili.effettivi.uscite.RegaliEffettiviEntity;
import com.project.bebudgeting.entity.mensili.effettivi.uscite.SpeseMedicheEffettiviEntity;
import com.project.bebudgeting.entity.mensili.effettivi.uscite.SpesePersonaliEffettiviEntity;
import com.project.bebudgeting.entity.mensili.effettivi.uscite.TrasportiEffettiviEntity;
import com.project.bebudgeting.entity.mensili.effettivi.uscite.ViaggiEffettiviEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "uscite_mensili_effettive")

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
 * @return UsciteMensiliEntity
 */

/**
 * @return List<AlimentiEffettiviEntity>
 */

/**
 * @return List<AltreUsciteEffettiveEntity>
 */

/**
 * @return List<AnimaliDomesticiEffettiviEntity>
 */

/**
 * @return List<BolletteEffettiviEntity>
 */

/**
 * @return List<CasaEffettiviEntity>
 */

/**
 * @return List<DebitiEffettiviEntity>
 */

/**
 * @return List<RegaliEffettiviEntity>
 */

/**
 * @return List<SpeseMedicheEffettiviEntity>
 */

/**
 * @return List<SpesePersonaliEffettiviEntity>
 */

/**
 * @return List<TrasportiEffettiviEntity>
 */

/**
 * @return List<ViaggiEffettiviEntity>
 */

/**
 * @return int
 */

/**
 * @return LocalDate
 */

/**
 * @return UsciteMensiliEntity
 */

/**
 * @return List<AlimentiEffettiviEntity>
 */

/**
 * @return List<AltreUsciteEffettiveEntity>
 */

/**
 * @return List<AnimaliDomesticiEffettiviEntity>
 */

/**
 * @return List<BolletteEffettiviEntity>
 */

/**
 * @return List<CasaEffettiviEntity>
 */

/**
 * @return List<DebitiEffettiviEntity>
 */

/**
 * @return List<RegaliEffettiviEntity>
 */

/**
 * @return List<SpeseMedicheEffettiviEntity>
 */

/**
 * @return List<SpesePersonaliEffettiviEntity>
 */

/**
 * @return List<TrasportiEffettiviEntity>
 */

/**
 * @return List<ViaggiEffettiviEntity>
 */
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
    private List<AlimentiEffettiviEntity> alimentiEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private List<AltreUsciteEffettiveEntity> altreUsciteEffettiveEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private List<AnimaliDomesticiEffettiviEntity> animaliDomesticiEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private List<BolletteEffettiviEntity> bolletteEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private List<CasaEffettiviEntity> casaEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private List<DebitiEffettiviEntity> debitiEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private List<RegaliEffettiviEntity> regaliEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private List<SpeseMedicheEffettiviEntity> speseMedicheEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private List<SpesePersonaliEffettiviEntity> spesePersonaliEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private List<TrasportiEffettiviEntity> trasportiEffettiviEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilieffettive")
    private List<ViaggiEffettiviEntity> viaggiEffettiviEntities;
}
