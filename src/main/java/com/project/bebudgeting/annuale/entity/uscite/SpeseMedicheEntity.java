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
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesemediche.AltroSpeseMedicheEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesemediche.CureSpecialisticheEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesemediche.DottoriEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesemediche.EmergenzeEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesemediche.FarmaciEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "spese_mediche")
@NoArgsConstructor
public class SpeseMedicheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;
    String descrizione;

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "idspesemediche")
    private Set<CureSpecialisticheEntity> cureSpecialisticheEntities;

    @OneToMany
    @JoinColumn(name = "idspesemediche")
    private Set<AltroSpeseMedicheEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idspesemediche")
    private Set<DottoriEntity> dottoriEntities;

    @OneToMany
    @JoinColumn(name = "idspesemediche")
    private Set<EmergenzeEntity> emergenzeEntities;

    @OneToMany
    @JoinColumn(name = "idspesemediche")
    private Set<FarmaciEntity> farmaciEntities;
}