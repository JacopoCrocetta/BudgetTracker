package com.project.bebudgeting.mensile.entity.effettivi.uscite;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.bebudgeting.mensile.entity.effettivi.UsciteEffettive;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Spese_Bollette_Effettive")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Bollette_Effettivi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUsciteMensiliEffettive")
    private UsciteEffettive entity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
