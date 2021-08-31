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
@Table(name = "altre_entrate")
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
    @JoinColumn(name = "entrateid", insertable = false, updatable = false)
    private EntrateAnnualiEntity entrata;

    @OneToMany
    @JoinColumn(name = "id_altre_entrate")
    private Set<AltroAltreEntrateEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "id_altre_entrate")
    private Set<DividendiEntity> dividendiEntities;

    @OneToMany
    @JoinColumn(name = "id_altre_entrate")
    private Set<InteressiEntity> interessiEntities;

    @OneToMany
    @JoinColumn(name = "id_altre_entrate")
    private Set<RegaliAltreEntrateEntity> regaliEntities;

    @OneToMany
    @JoinColumn(name = "id_altre_entrate")
    private Set<RimborsiEntity> rimborsiEntities;

    @OneToMany
    @JoinColumn(name = "id_altre_entrate")
    private Set<TrasferimentoRisparmiEntity> trasferimentoRisparmiEntities;
}
