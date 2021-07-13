package com.project.bebudgeting.annuale.entity.uscite;

import com.project.bebudgeting.annuale.entity.UscitaAnnuale;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AltreAssicurazioniEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneAutoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioassicurazione.AssicurazioneVitaEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@Table(name = "Assicurazioni")
@NoArgsConstructor
public class AssicurazioneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UscitaAnnuale uscitaAnnuale;

    @OneToMany(mappedBy = "Altre_Assicurazioni")
    private Set<AltreAssicurazioniEntity> altreAssicurazioniEntities;

    @OneToMany(mappedBy = "Assicurazione_Auto")
    private Set<AssicurazioneAutoEntity> assicurazioneAutoEntities;

    @OneToMany(mappedBy = "Assicurazione_Casa")
    private Set<AssicurazioneCasaEntity> assicurazioneCasaEntities;

    @OneToMany(mappedBy = "Assicurazione_Salute")
    private Set<AltreAssicurazioniEntity> assicurazioneSaluteEntities;

    @OneToMany(mappedBy = "Assicurazione_Vita")
    private Set<AssicurazioneVitaEntity> assicurazioneVitaEntities;
}