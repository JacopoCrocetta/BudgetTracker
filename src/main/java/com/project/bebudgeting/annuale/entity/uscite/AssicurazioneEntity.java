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
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneSaluteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "assicurazione")
@NoArgsConstructor
public class AssicurazioneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;
    String descrizione;

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "idassicurazione")
    private List<AltreAssicurazioniEntity> altreAssicurazioniEntities;

    @OneToMany
    @JoinColumn(name = "idassicurazione")
    private List<AssicurazioneAutoEntity> assicurazioneAutoEntities;

    @OneToMany
    @JoinColumn(name = "idassicurazione")
    private List<AssicurazioneCasaEntity> assicurazioneCasaEntities;

    @OneToMany
    @JoinColumn(name = "idassicurazione")
    private List<AssicurazioneSaluteEntity> assicurazioneSaluteEntities;

    @OneToMany
    @JoinColumn(name = "idassicurazione")
    private List<AssicurazioneVitaEntity> assicurazioneVitaEntities;
}