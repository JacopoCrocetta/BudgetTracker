package com.project.bebudgeting.entities.personalbudgetingentity.entrate.previste;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "InteressiPrevisti")
@Data
@NoArgsConstructor
@Getter
@Setter
public class InteressiPrevistiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate data;
    private BigDecimal importo;
    private String provenienzaInteressi;
}
