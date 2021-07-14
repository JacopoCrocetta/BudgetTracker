package com.project.bebudgeting.annuale.entity.uscite;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.UscitaAnnuale;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.AltroEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.AttivitaOutsideEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.ConcertiOSpettacoliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.FilmEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.FotografiaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.HobbyEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodivertimento.LibriEntity;
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
@Table(name = "Divertimento")
@NoArgsConstructor
public class DivertimentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UscitaAnnuale uscitaAnnuale;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy = "Attivita_Outside")
    private Set<AttivitaOutsideEntity> attivitaOutsideEntities;

    @OneToMany(mappedBy = "Concerti")
    private Set<ConcertiOSpettacoliEntity> concertiOSpettacoliEntities;

    @OneToMany(mappedBy = "Film")
    private Set<FilmEntity> filmEntities;

    @OneToMany(mappedBy = "Fotografia")
    private Set<FotografiaEntity> fotografiaEntities;

    @OneToMany(mappedBy = "Hobby")
    private Set<HobbyEntity> hobbyEntities;

    @OneToMany(mappedBy = "Libri")
    private Set<LibriEntity> libriEntities;

    @OneToMany(mappedBy = "Musica")
    private Set<MusicaEntity> musicaEntities;

    @OneToMany(mappedBy = "Partite")
    private Set<PartiteEntity> partiteEntities;

    @OneToMany(mappedBy = "Sport")
    private Set<SportEntity> sportEntities;

    @OneToMany(mappedBy = "Teatro")
    private Set<TeatroEntity> teatroEntities;

    @OneToMany(mappedBy = "Televisione")
    private Set<TVEntity> tvEntities;
}