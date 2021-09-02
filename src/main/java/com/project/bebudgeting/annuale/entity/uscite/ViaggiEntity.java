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
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.AlimentiViaggiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.AltroViaggiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.BigliettiAereiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.DivertimentoViaggiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.HotelEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioviaggi.TrasportiViaggiEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "viaggi")
@NoArgsConstructor
public class ViaggiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;
    String descrizione;

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "idviaggio")
    private List<AlimentiViaggiEntity> alimentiEntities;

    @OneToMany
    @JoinColumn(name = "idviaggio")
    private List<AltroViaggiEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idviaggio")
    private List<BigliettiAereiEntity> bigliettiAereiEntities;

    @OneToMany
    @JoinColumn(name = "idviaggio")
    private List<DivertimentoViaggiEntity> divertimentoEntities;

    @OneToMany
    @JoinColumn(name = "idviaggio")
    private List<HotelEntity> hotelEntities;

    @OneToMany
    @JoinColumn(name = "idviaggio")
    private List<TrasportiViaggiEntity> trasportiEntities;
}