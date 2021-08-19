package com.project.bebudgeting.annuale.entity.uscite;

import com.project.bebudgeting.annuale.entity.EntrateAnnualiEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Table(name = "Figli")
@NoArgsConstructor
public class FigliEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "idEntrata")
    private EntrateAnnualiEntity entrata;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroFigliEntity> altroEntities;

    @OneToMany(mappedBy = "Asilo")
    private Set<AsiloEntity> asiloEntities;

    @OneToMany(mappedBy = "Attivita")
    private Set<AttivitaEntity> attivitaEntities;

    @OneToMany(mappedBy = "Giocattoli")
    private Set<GiocattoliFigliEntity> giocattoliEntities;

    @OneToMany(mappedBy = "Paghetta")
    private Set<PaghettaEntity> paghettaEntities;

    @OneToMany(mappedBy = "Scuola")
    private Set<ScuolaEntity> scuolaEntities;

    @OneToMany(mappedBy = "SpeseMedicheFigli")
    private Set<SpeseMedicheFigliEntity> speseMedicheFigliEntities;

    @OneToMany(mappedBy = "Vestiti")
    private Set<VestitiFigliEntity> vestitiEntities;
}
