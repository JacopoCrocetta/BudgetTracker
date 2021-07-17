package com.project.bebudgeting.annuale.entity.entrate;

import com.project.bebudgeting.annuale.entity.EntrateAnnualiEntity;
import com.project.bebudgeting.annuale.entity.entrate.dettagliosalario.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Data
@Getter
@Setter
@Table(name = "Salario")
@NoArgsConstructor
public class SalarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idEntrata")
    private EntrateAnnualiEntity entrata;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy = "Bonus")
    private Set<BonusEntity> bonusEntities;

    @OneToMany(mappedBy = "BustaPaga")
    private Set<BustaPagaEntity> bustaPagaEntities;

    @OneToMany(mappedBy = "Commissioni")
    private Set<CommissioniEntity> commissioniEntities;

    @OneToMany(mappedBy = "Mance")
    private Set<ManceEntity> manceEntities;
}
