package com.project.bebudgeting.annuale.entity.uscite.dettagliocasa;

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
@Data
@Getter
@Setter
@Table(name = "giardinaggio")
@NoArgsConstructor
public class GiardinaggioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}