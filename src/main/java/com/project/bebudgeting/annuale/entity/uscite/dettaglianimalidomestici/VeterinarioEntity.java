package com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici;

import com.project.bebudgeting.annuale.entity.uscite.AnimaliDomesticiEntity;
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
@Table(name = "Veterinario")
@NoArgsConstructor
public class VeterinarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idAnimali")
    private AnimaliDomesticiEntity animaliDomesticiEntity;

    BigDecimal totale_mensile;
    LocalDate data_spesa;
    LocalDate data_inserimento;
    Boolean isAsilo;
}
