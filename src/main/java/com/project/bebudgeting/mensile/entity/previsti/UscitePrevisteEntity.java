package com.project.bebudgeting.mensile.entity.previsti;

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
    private List<AlimentiPrevistiEntity> alimentiPrevistiEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private List<AltreUscitePrevisteEntity> altreUscitePrevisteEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private List<AnimaliDomesticiPrevisteEntity> animaliDomesticiPrevisteEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private List<BollettePrevisteEntity> bollettePrevisteEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private List<CasaPrevisteEntity> casaPrevisteEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private List<DebitiPrevisteEntity> debitiPrevisteEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private List<RegaliPrevistiEntity> regaliPrevistiEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private List<SpeseMedichePrevistiEntity> speseMedichePrevistiEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private List<SpesePersonaliPrevistiEntity> spesePersonaliPrevistiEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private List<TrasportiPrevistiEntity> trasportiPrevistiEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensilipreviste")
    private List<ViaggiPrevistiEntity> viaggiPrevistiEntities;
}
