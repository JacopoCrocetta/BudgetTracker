package com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.uscite.TecnologiaEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "hardware")
@NoArgsConstructor
public class HardwareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idtecnologia", insertable = false, updatable = false)
    private TecnologiaEntity entity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}