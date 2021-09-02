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
    private List<AltroDivertimentoEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private List<AttivitaOutsideEntity> attivitaOutsideEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private List<ConcertiOSpettacoliEntity> concertiOSpettacoliEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private List<FilmEntity> filmEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private List<FotografiaEntity> fotografiaEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private List<HobbyEntity> hobbyEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private List<LibriDivertimentoEntity> libriEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private List<MusicaEntity> musicaEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private List<PartiteEntity> partiteEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private List<SportEntity> sportEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private List<TeatroEntity> teatroEntities;

    @OneToMany
    @JoinColumn(name = "iddivertimento")
    private List<TVEntity> tvEntities;
}