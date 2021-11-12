package com.project.bebudgeting.entity.mensili.effettivi.entrate;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.bebudgeting.entity.mensili.effettivi.EntrateEffettiveEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "busta_paga_effettivi")
@Data
@NoArgsConstructor
public class BustaPagaEffettiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "identrataeffettiva", insertable = false, updatable = false)
    private EntrateEffettiveEntity entity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
