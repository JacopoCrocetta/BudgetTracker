package com.project.bebudgeting.annuale.entity.uscite;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.EntrateAnnualiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AltroFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AsiloEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.AttivitaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.GiocattoliFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.PaghettaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.ScuolaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.SpeseMedicheFigliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliofigli.VestitiFigliEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<AltroFigliEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private List<AsiloEntity> asiloEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private List<AttivitaEntity> attivitaEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private List<GiocattoliFigliEntity> giocattoliEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private List<PaghettaEntity> paghettaEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private List<ScuolaEntity> scuolaEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private List<SpeseMedicheFigliEntity> speseMedicheFigliEntities;

    @OneToMany
    @JoinColumn(name = "idfigli")
    private List<VestitiFigliEntity> vestitiEntities;
}
