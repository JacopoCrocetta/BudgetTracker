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
@Table(name = "Istruzione")
@NoArgsConstructor
public class IstruzioneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany(mappedBy = "Lezioni_Indipendenti")
    private Set<LezioniIndipendentiEntity> lezioniIndipendentiEntities;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroIstruzioneEntity> altroEntities;

    @OneToMany(mappedBy = "Libri_Comprati")
    private Set<LibriIstruzioneEntity> libriEntities;

    @OneToMany(mappedBy = "Rette_Scolastiche")
    private Set<RetteEntity> retteEntities;
}