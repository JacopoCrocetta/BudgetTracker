package com.project.BEbudgeting.entities.personalbudgetingentity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Uscita")
@Data
@NoArgsConstructor
@Getter
@Setter
public class UscitePersonalBudgetEntity {

    LocalDateTime data;
    BigDecimal importo;
    String descrizione;
    CategoriaEntity categoria;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}
