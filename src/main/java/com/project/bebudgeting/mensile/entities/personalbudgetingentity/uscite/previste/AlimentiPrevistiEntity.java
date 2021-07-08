package com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.previste;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "AlimentiPrevisti")
@Data
@NoArgsConstructor
@Getter
@Setter
public class AlimentiPrevistiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate data;
    private BigDecimal importo;
}
