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
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AlimentiAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AltroAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.FornitureAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.GiocattoliAnimaliDomesticiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.VeterinarioAnimaliDomesticiEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    List<AlimentiAnimaliDomesticiEntity> alimentiEntities;

    @OneToMany
    @JoinColumn(name = "idanimali")
    List<AltroAnimaliDomesticiEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idanimali")
    List<FornitureAnimaliDomesticiEntity> fornitureEntities;

    @OneToMany
    @JoinColumn(name = "idanimali")
    List<GiocattoliAnimaliDomesticiEntity> giocattoliEntity;

    @OneToMany
    @JoinColumn(name = "idanimali")
    List<VeterinarioAnimaliDomesticiEntity> veterinarioEntities;
}