package com.project.bebudgeting.entity.mensili.previsti;

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
import com.project.bebudgeting.entity.mensili.previsti.entrate.AltreEntratePrevisteEntity;
import com.project.bebudgeting.entity.mensili.previsti.entrate.BonusPrevistiEntity;
import com.project.bebudgeting.entity.mensili.previsti.entrate.BustaPagaPrevisteEntity;
import com.project.bebudgeting.entity.mensili.previsti.entrate.InteressiPrevistiEntity;
import com.project.bebudgeting.entity.mensili.previsti.entrate.RisparmiPrevistiEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entrate_mensili_previste")
@Data
@NoArgsConstructor
public class EntratePrevisteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "identratemensile", insertable = false, updatable = false)
    private EntrateMensiliEntity entrateMensiliEntity;

    @OneToMany
    @JoinColumn(name = "identrataprevista")
    private List<AltreEntratePrevisteEntity> altreEntratePrevisteEntities;

    @OneToMany
    @JoinColumn(name = "identrataprevista")
    private List<BonusPrevistiEntity> bonusPrevistiEntities;

    @OneToMany
    @JoinColumn(name = "identrataprevista")
    private List<BustaPagaPrevisteEntity> bustaPagaPrevisteEntities;

    @OneToMany
    @JoinColumn(name = "identrataprevista")
    private List<InteressiPrevistiEntity> interessiPrevistiEntities;

    @OneToMany
    @JoinColumn(name = "RisparmiPrevistiEntity")
    private List<RisparmiPrevistiEntity> risparmiPrevistiEntities;
}
