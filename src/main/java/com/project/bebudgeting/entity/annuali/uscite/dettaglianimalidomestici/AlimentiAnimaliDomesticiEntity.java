package com.project.bebudgeting.entity.annuali.uscite.dettaglianimalidomestici;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

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

/**
 * @return int
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
@Table(name = "alimenti_animali")
@NoArgsConstructor
public class AlimentiAnimaliDomesticiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
