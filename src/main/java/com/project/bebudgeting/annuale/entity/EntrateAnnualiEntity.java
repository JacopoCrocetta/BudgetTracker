package com.project.bebudgeting.annuale.entity;

import com.project.bebudgeting.annuale.entity.entrate.AltreEntrateEntity;
import com.project.bebudgeting.annuale.entity.entrate.SalarioEntity;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EntrataAnnuale")
@Data
@NoArgsConstructor
@Getter
@Setter
public class EntrateAnnualiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "Salario")
    private Set<SalarioEntity> salarioEntities;

    @OneToMany(mappedBy = "ALtreEntrate")
    private Set<AltreEntrateEntity> altreEntrateEntities;

    LocalDate data_inserimento;
}
