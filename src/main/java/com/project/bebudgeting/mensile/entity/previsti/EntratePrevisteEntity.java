package com.project.bebudgeting.mensile.entity.previsti;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.mensile.entity.previsti.entrate.AltreEntratePrevisteEntity;
import com.project.bebudgeting.mensile.entity.previsti.entrate.BonusPrevistiEntity;
import com.project.bebudgeting.mensile.entity.previsti.entrate.BustaPagaPrevisteEntity;
import com.project.bebudgeting.mensile.entity.previsti.entrate.InteressiPrevistiEntity;
import com.project.bebudgeting.mensile.entity.previsti.entrate.RisparmiPrevistiEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Entrate_Previste")
@Data
@NoArgsConstructor
@Getter
@Setter
public class EntratePrevisteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @OneToMany(mappedBy = "AltreEntratePrevisteEntity")
    private Set<AltreEntratePrevisteEntity> altreEntratePrevisteEntities;

    @OneToMany(mappedBy = "BonusPrevistiEntity")
    private Set<BonusPrevistiEntity> bonusPrevistiEntities;

    @OneToMany(mappedBy = "BustaPagaPrevisteEntity")
    private Set<BustaPagaPrevisteEntity> bustaPagaPrevisteEntities;

    @OneToMany(mappedBy = "InteressiPrevistiEntity")
    private Set<InteressiPrevistiEntity> interessiPrevistiEntities;

    @OneToMany(mappedBy = "RisparmiPrevistiEntity")
    private Set<RisparmiPrevistiEntity> risparmiPrevistiEntities;
}
