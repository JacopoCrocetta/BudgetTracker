package com.project.bebudgeting.annuale.entity.uscite;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.UsciteAnnualiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.AltroDivertimentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.AttivitaOutsideEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.ConcertiOSpettacoliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.FilmEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.FotografiaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.HobbyEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.LibriDivertimentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.MusicaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.PartiteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.SportEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.TVEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.TeatroEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "divertimento")
@NoArgsConstructor
public class DivertimentoUsciteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;
    String descrizione;

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<AltroDivertimentoEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<AttivitaOutsideEntity> attivitaOutsideEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<ConcertiOSpettacoliEntity> concertiOSpettacoliEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<FilmEntity> filmEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<FotografiaEntity> fotografiaEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<HobbyEntity> hobbyEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<LibriDivertimentoEntity> libriEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<MusicaEntity> musicaEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<PartiteEntity> partiteEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<SportEntity> sportEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<TeatroEntity> teatroEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private Set<TVEntity> tvEntities;
}