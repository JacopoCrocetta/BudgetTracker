package com.project.bebudgeting.annuale.entity.entrate.dettaglioaltreentrate;

import com.project.bebudgeting.annuale.entity.entrate.AltreEntrateEntity;
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
@Table(name = "Altre_Entrate")
@NoArgsConstructor
public class AltroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany
    @JoinColumn(name = "id_Altre_Entrate")
    private AltreEntrateEntity altreEntrateEntityEntity;

    BigDecimal totale_mensile;
    LocalDate data_inserimento;
    String descrizioneEntrata;
}
