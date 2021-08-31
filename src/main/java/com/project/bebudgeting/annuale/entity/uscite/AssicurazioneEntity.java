package com.project.bebudgeting.annuale.entity.uscite;

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

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "idassicurazione")
    private Set<AltreAssicurazioniEntity> altreAssicurazioniEntities;

    @OneToMany
    @JoinColumn(name = "idassicurazione")
    private Set<AssicurazioneAutoEntity> assicurazioneAutoEntities;

    @OneToMany
    @JoinColumn(name = "idassicurazione")
    private Set<AssicurazioneCasaEntity> assicurazioneCasaEntities;

    @OneToMany
    @JoinColumn(name = "idassicurazione")
    private Set<AssicurazioneSaluteEntity> assicurazioneSaluteEntities;

    @OneToMany
    @JoinColumn(name = "idassicurazione")
    private Set<AssicurazioneVitaEntity> assicurazioneVitaEntities;
}