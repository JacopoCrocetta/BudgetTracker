package com.project.bebudgeting.annuale.entity.uscite.dettagliofigli;

import com.project.bebudgeting.annuale.entity.uscite.FigliEntity;
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
@Table(name = "altro_figli")
@NoArgsConstructor
public class AltroFigliEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idfigli", insertable = false, updatable = false)
    private FigliEntity figliEntity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
