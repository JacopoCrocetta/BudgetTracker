package com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.uscite.SpeseQuotidianeEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "lavanderia")
@NoArgsConstructor
public class LavanderiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idspesequotidiane", insertable = false, updatable = false)
    private SpeseQuotidianeEntity entity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}