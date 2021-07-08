package com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.previste;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "AltreCategorieEntratePreviste")
@Data
@NoArgsConstructor
@Getter
@Setter
public class AltreCategorieEntratePrevisteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate data;
    private BigDecimal importo;
    private String descrizioneCategoria;
}
