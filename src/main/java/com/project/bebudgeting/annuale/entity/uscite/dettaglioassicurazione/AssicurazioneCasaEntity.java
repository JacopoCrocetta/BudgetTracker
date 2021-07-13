package com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione;

import com.project.bebudgeting.annuale.entity.uscite.AssicurazioneEntity;
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
@Table(name = "Assicurazione_Casa")
@NoArgsConstructor
public class AssicurazioneCasaEntity {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "idAssicurazione")
    private AssicurazioneEntity assicurazioneEntity;

    BigDecimal totale_mensile;
    LocalDate data_spesa;
    LocalDate data_inserimento;
}
