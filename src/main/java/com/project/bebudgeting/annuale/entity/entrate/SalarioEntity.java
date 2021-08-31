package com.project.bebudgeting.annuale.entity.entrate;

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

import com.project.bebudgeting.annuale.entity.EntrateAnnualiEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.AltroSalarioEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.BonusEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.BustaPagaEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.CommissioniEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.ManceEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "Salario")
@NoArgsConstructor
public class SalarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "entrateid", insertable = false, updatable = false)
    private EntrateAnnualiEntity entrata;

    @OneToMany
    @JoinColumn(name = "idSalario")
    private Set<AltroSalarioEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idSalario")
    private Set<BonusEntity> bonusEntities;

    @OneToMany
    @JoinColumn(name = "idSalario")
    private Set<BustaPagaEntity> bustaPagaEntities;

    @OneToMany
    @JoinColumn(name = "idSalario")
    private Set<CommissioniEntity> commissioniEntities;

    @OneToMany
    @JoinColumn(name = "idSalario")
    private Set<ManceEntity> manceEntities;
}
