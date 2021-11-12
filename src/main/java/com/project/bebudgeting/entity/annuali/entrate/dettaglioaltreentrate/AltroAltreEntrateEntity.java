package com.project.bebudgeting.entity.annuali.entrate.dettaglioaltreentrate;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "altre_entrate_ae")
@NoArgsConstructor
public class AltroAltreEntrateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizioneEntrata;
}
