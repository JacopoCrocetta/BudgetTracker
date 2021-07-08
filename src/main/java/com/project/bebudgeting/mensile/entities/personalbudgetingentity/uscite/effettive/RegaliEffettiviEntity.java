package com.project.bebudgeting.mensile.entities.personalbudgetingentity.uscite.effettive;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "RegaliEffettivi")
@Data
@NoArgsConstructor
@Getter
@Setter
public class RegaliEffettiviEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate data;
    private BigDecimal importo;
}
