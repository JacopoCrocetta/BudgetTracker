package com.project.bebudgeting.annuale.entity.uscite.dettagliobollette;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.uscite.BolletteEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "bollette_telefono")
@NoArgsConstructor
public class BolletteTelefonoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idbollette", insertable = false, updatable = false)
    private BolletteEntity bolletteEntity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}