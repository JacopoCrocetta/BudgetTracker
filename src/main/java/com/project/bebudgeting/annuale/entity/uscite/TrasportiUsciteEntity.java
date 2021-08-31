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
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.AltroTrasportiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.BolloEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.CarburanteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.FornitureTrasportiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.PrestitoAutoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.RiparazioniEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.TrasportoPubblicoEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "trasporti")
@NoArgsConstructor
public class TrasportiUsciteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;
    String descrizione;

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "idtrasporti")
    private Set<BolloEntity> bolloEntities;

    @OneToMany
    @JoinColumn(name = "idtrasporti")
    private Set<AltroTrasportiEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idtrasporti")
    private Set<CarburanteEntity> carburanteEntities;

    @OneToMany
    @JoinColumn(name = "idtrasporti")
    private Set<FornitureTrasportiEntity> fornitureEntities;

    @OneToMany
    @JoinColumn(name = "idtrasporti")
    private Set<PrestitoAutoEntity> prestitoAutoEntities;

    @OneToMany
    @JoinColumn(name = "idtrasporti")
    private Set<RiparazioniEntity> riparazioniEntities;

    @OneToMany
    @JoinColumn(name = "idtrasporti")
    private Set<TrasportoPubblicoEntity> trasportoPubblicoEntities;
}