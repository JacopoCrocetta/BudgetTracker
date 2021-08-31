package com.project.bebudgeting.annuale.entity.uscite;

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

import com.project.bebudgeting.annuale.entity.UsciteAnnualiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.AltreBolletteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteAcquaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteElettricitaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteGASEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteInternetEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteRifiutiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteTVEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliobollette.BolletteTelefonoEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "bollette")
@NoArgsConstructor
public class BolletteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private Set<AltreBolletteEntity> altreBolletteEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private Set<BolletteAcquaEntity> bolletteAcquaEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private Set<BolletteElettricitaEntity> bolletteElettricitaEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private Set<BolletteGASEntity> bolletteGASEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private Set<BolletteInternetEntity> bolletteInternetEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private Set<BolletteRifiutiEntity> bolletteRifiutiEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private Set<BolletteTelefonoEntity> bolletteTelefonoEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private Set<BolletteTVEntity> bolletteTVEntities;
}