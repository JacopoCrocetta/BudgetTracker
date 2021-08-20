package com.project.bebudgeting.mensile.entity.previsti;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.mensile.entity.previsti.uscite.AlimentiPrevistiEntity;
import com.project.bebudgeting.mensile.entity.previsti.uscite.AltreUscitePrevisteEntity;
import com.project.bebudgeting.mensile.entity.previsti.uscite.AnimaliDomesticiPrevisteEntity;
import com.project.bebudgeting.mensile.entity.previsti.uscite.BollettePrevisteEntity;
import com.project.bebudgeting.mensile.entity.previsti.uscite.CasaPrevisteEntity;
import com.project.bebudgeting.mensile.entity.previsti.uscite.DebitiPrevisteEntity;
import com.project.bebudgeting.mensile.entity.previsti.uscite.RegaliPrevistiEntity;
import com.project.bebudgeting.mensile.entity.previsti.uscite.SpeseMedichePrevistiEntity;
import com.project.bebudgeting.mensile.entity.previsti.uscite.SpesePersonaliPrevistiEntity;
import com.project.bebudgeting.mensile.entity.previsti.uscite.TrasportiPrevistiEntity;
import com.project.bebudgeting.mensile.entity.previsti.uscite.ViaggiPrevistiEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Uscite_Previste")
@Data
@NoArgsConstructor
@Getter
@Setter
public class UscitePrevisteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @OneToMany(mappedBy = "AlimentiPrevistiEntity")
    private Set<AlimentiPrevistiEntity> alimentiPrevistiEntities;

    @OneToMany(mappedBy = "AltreUscitePrevisteEntity")
    private Set<AltreUscitePrevisteEntity> altreUscitePrevisteEntities;

    @OneToMany(mappedBy = "AnimaliDomesticiPrevisteEntity")
    private Set<AnimaliDomesticiPrevisteEntity> animaliDomesticiPrevisteEntities;

    @OneToMany(mappedBy = "BollettePrevisteEntity")
    private Set<BollettePrevisteEntity> bollettePrevisteEntities;

    @OneToMany(mappedBy = "CasaPrevisteEntity")
    private Set<CasaPrevisteEntity> casaPrevisteEntities;

    @OneToMany(mappedBy = "DebitiPrevisteEntity")
    private Set<DebitiPrevisteEntity> debitiPrevisteEntities;

    @OneToMany(mappedBy = "RegaliPrevistiEntity")
    private Set<RegaliPrevistiEntity> regaliPrevistiEntities;

    @OneToMany(mappedBy = "SpeseMedicheEffettiviEntity")
    private Set<SpeseMedichePrevistiEntity> speseMedichePrevistiEntities;

    @OneToMany(mappedBy = "SpesePersonaliPrevistiEntity")
    private Set<SpesePersonaliPrevistiEntity> spesePersonaliPrevistiEntities;

    @OneToMany(mappedBy = "TrasportiPrevistiEntity")
    private Set<TrasportiPrevistiEntity> trasportiPrevistiEntities;

    @OneToMany(mappedBy = "ViaggiPrevistiEntity")
    private Set<ViaggiPrevistiEntity> viaggiPrevistiEntities;
}
