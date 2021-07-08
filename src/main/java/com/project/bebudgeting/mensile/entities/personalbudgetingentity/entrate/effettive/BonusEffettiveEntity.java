package com.project.bebudgeting.mensile.entities.personalbudgetingentity.entrate.effettive;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "BonusEffettive")
@Data
@NoArgsConstructor
@Getter
@Setter
public class BonusEffettiveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate data;
    private BigDecimal importo;
}
