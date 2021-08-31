package com.project.bebudgeting.annuale.entity.entrate.dettagliosalario;

import com.project.bebudgeting.annuale.entity.entrate.SalarioEntity;
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
@Table(name = "Altre_Entrate")
@NoArgsConstructor
public class AltroSalarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idSalario", referencedColumnName = "id", insertable = false, updatable = false)
    private SalarioEntity salarioEntity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
