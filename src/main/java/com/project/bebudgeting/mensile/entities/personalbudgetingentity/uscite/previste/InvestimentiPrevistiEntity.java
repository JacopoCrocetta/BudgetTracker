package com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.previste;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "InvestimentiPrevisti")
@Data
@NoArgsConstructor
@Getter
@Setter
public class InvestimentiPrevistiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate dataInvestimento;
    private BigDecimal importo;
    private String tipologia;
}
