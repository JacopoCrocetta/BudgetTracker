package com.project.bebudgeting.annuale.entity.uscite;

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
    String descrizione;

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private List<AltreBolletteEntity> altreBolletteEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private List<BolletteAcquaEntity> bolletteAcquaEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private List<BolletteElettricitaEntity> bolletteElettricitaEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private List<BolletteGASEntity> bolletteGASEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private List<BolletteInternetEntity> bolletteInternetEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private List<BolletteRifiutiEntity> bolletteRifiutiEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private List<BolletteTelefonoEntity> bolletteTelefonoEntities;

    @OneToMany
    @JoinColumn(name = "idbollette")
    private List<BolletteTVEntity> bolletteTVEntities;
}