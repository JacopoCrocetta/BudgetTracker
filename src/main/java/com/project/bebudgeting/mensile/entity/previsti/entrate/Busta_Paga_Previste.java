package com.project.bebudgeting.mensile.entity.previsti.entrate;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.bebudgeting.mensile.entity.previsti.EntratePreviste;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Busta_Paga_Previste")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Busta_Paga_Previste {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idEntrataPrevista")
    private EntratePreviste entity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
