package com.project.bebudgeting.entities.personalbudgetingentity.uscite.effettive;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "AltreCategorieUsciteEffettive")
@Data
@NoArgsConstructor
@Getter
@Setter
public class AltreCategorieUsciteEffettiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate data;
    private BigDecimal importo;
    private String descrizioneCategoria;
    private String descrizioneSpesa;
}
