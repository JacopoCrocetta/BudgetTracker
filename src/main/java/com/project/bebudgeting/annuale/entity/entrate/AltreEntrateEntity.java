package com.project.bebudgeting.annuale.entity.entrate;

import com.project.bebudgeting.annuale.entity.EntrataAnnuale;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.*;
import com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate.AltroEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "idEntrata")
    private EntrataAnnuale entrata;

    @OneToMany(mappedBy="Altro")
    private Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy="Dividendi")
    private Set<DividendiEntity> dividendiEntities;

    @OneToMany(mappedBy="Interessi")
    private Set<InteressiEntity> interessiEntities;

    @OneToMany(mappedBy="Regali")
    private Set<RegaliEntity> regaliEntities;

    @OneToMany(mappedBy="Rimborsi")
    private Set<RimborsiEntity> manceEntities;

    @OneToMany(mappedBy="TrasferimentoRisparmi")
    private Set<TrasferimentoRisparmiEntity> trasferimentoRisparmiEntities;
}
