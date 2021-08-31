package com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate;

import com.project.bebudgeting.annuale.entity.entrate.AltreEntrateEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@Table(name = "Interessi")
@NoArgsConstructor
public class DividendiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_Altre_Entrate", referencedColumnName = "id", insertable = false, updatable = false)
    private AltreEntrateEntity altreEntrateEntityEntity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
