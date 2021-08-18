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
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.AlimentiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.AltroEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.BigliettiAereiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.DivertimentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.HotelEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.TrasportiEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "Viaggi")
@NoArgsConstructor
public class ViaggiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany(mappedBy = "Alimenti")
    private Set<AlimentiEntity> alimentiEntities;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy = "Biglietti_Aerei")
    private Set<BigliettiAereiEntity> bigliettiAereiEntities;

    @OneToMany(mappedBy = "Divertimento")
    private Set<DivertimentoEntity> divertimentoEntities;

    @OneToMany(mappedBy = "Hotel")
    private Set<HotelEntity> hotelEntities;

    @OneToMany(mappedBy = "Trasporti")
    private Set<TrasportiEntity> trasportiEntities;
}