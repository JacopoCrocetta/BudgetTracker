package com.project.bebudgeting.annuale.entity.entrate;

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

import com.project.bebudgeting.annuale.entity.EntrateAnnualiEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.AltroAltreEntrateEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.DividendiEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.InteressiEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.RegaliAltreEntrateEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.RimborsiEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.TrasferimentoRisparmiEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<AltroAltreEntrateEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "id_altre_entrate")
    private List<DividendiEntity> dividendiEntities;

    @OneToMany
    @JoinColumn(name = "id_altre_entrate")
    private List<InteressiEntity> interessiEntities;

    @OneToMany
    @JoinColumn(name = "id_altre_entrate")
    private List<RegaliAltreEntrateEntity> regaliEntities;

    @OneToMany
    @JoinColumn(name = "id_altre_entrate")
    private List<RimborsiEntity> rimborsiEntities;

    @OneToMany
    @JoinColumn(name = "id_altre_entrate")
    private List<TrasferimentoRisparmiEntity> trasferimentoRisparmiEntities;
}
