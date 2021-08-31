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
@Table(name = "animali_domestici")
@NoArgsConstructor
public class AnimaliDomesticiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;
    String descrizione;

    @ManyToOne
    @JoinColumn(name = "iduscita", insertable = false, updatable = false)
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "idanimali")
    Set<AlimentiAnimaliDomesticiEntity> alimentiEntities;

    @OneToMany
    @JoinColumn(name = "idanimali")
    Set<AltroAnimaliDomesticiEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idanimali")
    Set<FornitureAnimaliDomesticiEntity> fornitureEntities;

    @OneToMany
    @JoinColumn(name = "idanimali")
    Set<GiocattoliAnimaliDomesticiEntity> giocattoliEntity;

    @OneToMany
    @JoinColumn(name = "idanimali")
    Set<VeterinarioAnimaliDomesticiEntity> veterinarioEntities;
}