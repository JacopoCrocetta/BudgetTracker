package com.project.bebudgeting.entity.annuali.uscite.dettagliobollette;

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
@Table(name = "bollette_internet")
@NoArgsConstructor
public class BolletteInternetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}