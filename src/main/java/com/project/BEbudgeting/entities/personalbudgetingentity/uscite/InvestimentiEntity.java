package com.project.BEbudgeting.entities.personalbudgetingentity.uscite;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "InteressiEntity")
@Data
@NoArgsConstructor
@Getter
@Setter
public class InvestimentiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate dataInvestimento;
    private BigDecimal importo;
    private String tipologia;
}
