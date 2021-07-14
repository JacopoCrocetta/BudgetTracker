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
import com.project.bebudgeting.annuale.entity.uscite.dettaglioistruzione.AltroEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioistruzione.LezioniIndipendentiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioistruzione.LibriEntity;
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

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UscitaAnnuale uscitaAnnuale;

    @OneToMany(mappedBy = "Lezioni_Indipendenti")
    private Set<LezioniIndipendentiEntity> lezioniIndipendentiEntities;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy = "Libri_Comprati")
    private Set<LibriEntity> libriEntities;

    @OneToMany(mappedBy = "Rette_Scolastiche")
    private Set<RetteEntity> retteEntities;
}