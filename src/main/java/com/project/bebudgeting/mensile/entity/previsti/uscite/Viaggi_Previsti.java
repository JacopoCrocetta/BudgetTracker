package com.project.bebudgeting.mensile.entity.previsti.uscite;

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
@Table(name = "Spese_Viaggi_Previste")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Viaggi_Previsti {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUsciteMensiliPreviste")
    private UsciteEffettive entity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
