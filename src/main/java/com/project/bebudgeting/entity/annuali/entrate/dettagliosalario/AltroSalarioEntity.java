package com.project.bebudgeting.entity.annuali.entrate.dettagliosalario;

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
@Table(name = "altro_salario")
@NoArgsConstructor
public class AltroSalarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
