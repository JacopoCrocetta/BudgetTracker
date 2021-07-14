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

import com.project.bebudgeting.annuale.entity.UscitaAnnuale;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesemediche.AltroEntity;
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
@Table(name = "Spese_Mediche")
@NoArgsConstructor
public class SpeseMedicheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UscitaAnnuale uscitaAnnuale;

    @OneToMany(mappedBy = "Cure_Specialistiche")
    private Set<CureSpecialisticheEntity> cureSpecialisticheEntities;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy = "Dottore")
    private Set<DottoriEntity> dottoriEntities;

    @OneToMany(mappedBy = "Emergente")
    private Set<EmergenzeEntity> emergenzeEntities;

    @OneToMany(mappedBy = "Farmaci")
    private Set<FarmaciEntity> farmaciEntities;
}