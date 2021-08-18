package com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione;

import com.project.bebudgeting.annuale.entity.uscite.AssicurazioneEntity;
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
@Table(name = "Assiurazione_Salute")
@NoArgsConstructor
public class AssicurazioneSaluteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idAssicurazione")
    private AssicurazioneEntity assicurazioneEntity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
