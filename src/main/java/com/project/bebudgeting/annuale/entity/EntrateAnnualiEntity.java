package com.project.bebudgeting.annuale.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.entrate.AltreEntrateEntity;
import com.project.bebudgeting.annuale.entity.entrate.SalarioEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entrate_annuali")
@Data
@NoArgsConstructor
@Getter
@Setter
public class EntrateAnnualiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @OneToMany
    @JoinColumn(name = "entrateid")
    private List<SalarioEntity> salarioEntities;

    @OneToMany
    @JoinColumn(name = "entrateid")
    private List<AltreEntrateEntity> altreEntrateEntities;

}
