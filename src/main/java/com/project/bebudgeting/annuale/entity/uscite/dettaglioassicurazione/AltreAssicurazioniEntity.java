package com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione;

import com.project.bebudgeting.annuale.entity.uscite.AssicurazioneEntity;
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
@Table(name = "Altre_Assicurazioni")
@NoArgsConstructor
public class AltreAssicurazioniEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idFigli")
    private AssicurazioneEntity assicurazioneEntity;

    BigDecimal totale_mensile;
    LocalDate data_spesa;
    LocalDate data_inserimento;
    Boolean isAsilo;
}
