package com.project.bebudgeting.annuale.entity.uscite;

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
@Table(name = "Bollette")
@NoArgsConstructor
public class BolletteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany(mappedBy = "Altre_Bollette")
    private Set<AltreBolletteEntity> altreBolletteEntities;

    @OneToMany(mappedBy = "Bollette_Acqua")
    private Set<BolletteAcquaEntity> bolletteAcquaEntities;

    @OneToMany(mappedBy = "Bollette_Elettricita")
    private Set<BolletteElettricitaEntity> bolletteElettricitaEntities;

    @OneToMany(mappedBy = "Bollette_Gas")
    private Set<BolletteGASEntity> bolletteGASEntities;

    @OneToMany(mappedBy = "Bollette_Internet")
    private Set<BolletteInternetEntity> bolletteInternetEntities;

    @OneToMany(mappedBy = "Bollette_Rifiuti")
    private Set<BolletteRifiutiEntity> bolletteRifiutiEntities;

    @OneToMany(mappedBy = "Bollette_Telefono")
    private Set<BolletteTelefonoEntity> bolletteTelefonoEntities;

    @OneToMany(mappedBy = "Bollette_TV")
    private Set<BolletteTVEntity> bolletteTVEntities;
}