package com.project.bebudgeting.annuale.entity.uscite;

import com.project.bebudgeting.annuale.entity.UsciteAnnualiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AlimentiAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AltroAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.FornitureAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.GiocattoliAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.VeterinarioAnimaliDomesticiEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Table(name = "Animali_Domestici")
@NoArgsConstructor
public class AnimaliDomesticiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany(mappedBy = "Alimenti")
    Set<AlimentiAnimaliDomesticiEntity> alimentiEntities;

    @OneToMany(mappedBy = "Altro")
    Set<AltroAnimaliDomesticiEntity> altroEntities;

    @OneToMany(mappedBy = "Forniture")
    Set<FornitureAnimaliDomesticiEntity> fornitureEntities;

    @OneToMany(mappedBy = "Giocattoli")
    Set<GiocattoliAnimaliDomesticiEntity> giocattoliEntity;

    @OneToMany(mappedBy = "Veterinario")
    Set<VeterinarioAnimaliDomesticiEntity> veterinarioEntities;
}