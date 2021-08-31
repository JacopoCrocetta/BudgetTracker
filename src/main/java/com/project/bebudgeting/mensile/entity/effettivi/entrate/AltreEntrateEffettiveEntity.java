package com.project.bebudgeting.mensile.entity.effettivi.entrate;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.bebudgeting.mensile.entity.previsti.EntratePrevisteEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "altre_entrate_effettive")
@Data
@NoArgsConstructor
@Getter
@Setter
public class AltreEntrateEffettiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "identrataeffettiva", insertable = false, updatable = false)
    private EntratePrevisteEntity entity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}