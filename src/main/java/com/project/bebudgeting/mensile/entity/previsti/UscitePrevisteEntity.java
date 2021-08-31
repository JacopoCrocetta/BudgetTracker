package com.project.bebudgeting.mensile.entity.previsti;

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
@Table(name = "uscite_mensili_previste")
@Data
@NoArgsConstructor
@Getter
@Setter
public class UscitePrevisteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "iduscitemensile", insertable = false, updatable = false)
    private UsciteMensiliEntity usciteMensiliEntity;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private Set<AlimentiPrevistiEntity> alimentiPrevistiEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private Set<AltreUscitePrevisteEntity> altreUscitePrevisteEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private Set<AnimaliDomesticiPrevisteEntity> animaliDomesticiPrevisteEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private Set<BollettePrevisteEntity> bollettePrevisteEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private Set<CasaPrevisteEntity> casaPrevisteEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private Set<DebitiPrevisteEntity> debitiPrevisteEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private Set<RegaliPrevistiEntity> regaliPrevistiEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private Set<SpeseMedichePrevistiEntity> speseMedichePrevistiEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private Set<SpesePersonaliPrevistiEntity> spesePersonaliPrevistiEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private Set<TrasportiPrevistiEntity> trasportiPrevistiEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private Set<ViaggiPrevistiEntity> viaggiPrevistiEntities;
}
