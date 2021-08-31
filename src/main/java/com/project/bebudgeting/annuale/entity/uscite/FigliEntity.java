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
@Table(name = "figli")
@NoArgsConstructor
public class FigliEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;
    String descrizione;

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private EntrateAnnualiEntity entrata;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private Set<AltroFigliEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private Set<AsiloEntity> asiloEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private Set<AttivitaEntity> attivitaEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private Set<GiocattoliFigliEntity> giocattoliEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private Set<PaghettaEntity> paghettaEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private Set<ScuolaEntity> scuolaEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private Set<SpeseMedicheFigliEntity> speseMedicheFigliEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private Set<VestitiFigliEntity> vestitiEntities;
}
