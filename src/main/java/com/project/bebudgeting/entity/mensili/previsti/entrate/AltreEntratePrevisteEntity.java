package com.project.bebudgeting.entity.mensili.previsti.entrate;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.bebudgeting.entity.mensili.previsti.EntratePrevisteEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "altre_entrate_effettive")
@Data
@NoArgsConstructor
public class AltreEntratePrevisteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "identrataprevista", insertable = false, updatable = false)
    private EntratePrevisteEntity entity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}