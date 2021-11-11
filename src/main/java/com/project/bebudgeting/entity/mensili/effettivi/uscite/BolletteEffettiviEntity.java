package com.project.bebudgeting.entity.mensili.effettivi.uscite;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.bebudgeting.entity.mensili.effettivi.UsciteEffettiveEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "spese_bollette_effettive")

/**
 * @return boolean
 */

/**
 * @return boolean
 */

/**
 * @return int
 */

/**
 * @return String
 */

/**
 * @return boolean
 */

/**
 * @return boolean
 */

/**
 * @return int
 */

/**
 * @return String
 */
@Data
@NoArgsConstructor

/**
 * @return int
 */

/**
 * @return UsciteEffettiveEntity
 */

/**
 * @return BigDecimal
 */

/**
 * @return LocalDate
 */

/**
 * @return String
 */

/**
 * @return int
 */

/**
 * @return UsciteEffettiveEntity
 */

/**
 * @return BigDecimal
 */

/**
 * @return LocalDate
 */

/**
 * @return String
 */
@Getter
@Setter
public class BolletteEffettiviEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "iduscitemensilieffettive", insertable = false, updatable = false)
    private UsciteEffettiveEntity entity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
