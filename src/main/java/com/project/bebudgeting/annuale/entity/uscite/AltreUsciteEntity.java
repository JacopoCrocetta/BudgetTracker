package com.project.bebudgeting.annuale.entity.uscite;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.UsciteAnnualiEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "Altre_Uscite")
@NoArgsConstructor
public class AltreUsciteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    BigDecimal totale_mensile;
    LocalDate data_spesa;
    LocalDate data_inserimento;
    String descrizione;
}