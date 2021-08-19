package com.project.bebudgeting.annuale.entity.entrate;

import com.project.bebudgeting.annuale.entity.EntrateAnnualiEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.*;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.AltroAltreEntrateEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

@Entity
@Table(name = "Altre_Entrate")
@Data
@Getter
@Setter
@NoArgsConstructor
public class AltreEntrateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "idEntrata")
    private EntrateAnnualiEntity entrata;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroAltreEntrateEntity> altroEntities;

    @OneToMany(mappedBy = "Dividendi")
    private Set<DividendiEntity> dividendiEntities;

    @OneToMany(mappedBy = "Interessi")
    private Set<InteressiEntity> interessiEntities;

    @OneToMany(mappedBy = "Regali")
    private Set<RegaliEntity> regaliEntities;

    @OneToMany(mappedBy = "Rimborsi")
    private Set<RimborsiEntity> rimborsiEntities;

    @OneToMany(mappedBy = "TrasferimentoRisparmi")
    private Set<TrasferimentoRisparmiEntity> trasferimentoRisparmiEntities;
}
