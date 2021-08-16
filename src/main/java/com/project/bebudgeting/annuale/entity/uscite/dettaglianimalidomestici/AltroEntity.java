package com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici;

import com.project.bebudgeting.annuale.entity.uscite.AnimaliDomesticiEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Getter
@Setter
@Table(name = "Altro")
@NoArgsConstructor
public class AltroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idAnimali")
    private AnimaliDomesticiEntity animaliDomesticiEntity;

    BigDecimal totale_mensile;
    LocalDate data_spesa;
    LocalDate data_inserimento;
    String descrizione;
}
