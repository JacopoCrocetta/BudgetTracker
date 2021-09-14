package com.project.bebudgeting.annuale.entity.uscite;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.uscite.dettaglioistruzione.AltroIstruzioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioistruzione.LezioniIndipendentiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioistruzione.LibriIstruzioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioistruzione.RetteEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "istruzione")
@NoArgsConstructor
public class IstruzioneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;
    String descrizione;

    @OneToMany
    @JoinColumn(name = "idistruzione")
    private List<LezioniIndipendentiEntity> lezioniIndipendentiEntities;

    @OneToMany
    @JoinColumn(name = "idistruzione")
    private List<AltroIstruzioneEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idistruzione")
    private List<LibriIstruzioneEntity> libriEntities;

    @OneToMany
    @JoinColumn(name = "idistruzione")
    private List<RetteEntity> retteEntities;
}