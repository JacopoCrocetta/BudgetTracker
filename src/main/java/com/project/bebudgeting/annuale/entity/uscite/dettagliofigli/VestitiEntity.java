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
@Table(name = "Vestiti")
@NoArgsConstructor
public class VestitiEntity {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "idFigli")
    private FigliEntity figliEntity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizione;
}
