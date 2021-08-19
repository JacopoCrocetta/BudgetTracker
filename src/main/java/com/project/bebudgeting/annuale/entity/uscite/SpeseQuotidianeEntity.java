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
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.AbbonamentiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.AltroSpeseQuotidianeEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.IgienePersonaleEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.LavanderiaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.ParrucchiereEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.RistorantiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.SupermercatoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliospesequotidiane.VestitiSpeseQuotidianeEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "Spese_Quotidiane")
@NoArgsConstructor
public class SpeseQuotidianeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroSpeseQuotidianeEntity> altroEntities;

    @OneToMany(mappedBy = "Abbonamenti")
    private Set<AbbonamentiEntity> abbonamentiEntities;

    @OneToMany(mappedBy = "Igiene_Personale")
    private Set<IgienePersonaleEntity> igienePersonaleEntities;

    @OneToMany(mappedBy = "Lavanderia")
    private Set<LavanderiaEntity> lavanderiaEntities;

    @OneToMany(mappedBy = "Parrucchiere")
    private Set<ParrucchiereEntity> parrucchiereEntities;

    @OneToMany(mappedBy = "Ristoranti")
    private Set<RistorantiEntity> ristorantiEntities;

    @OneToMany(mappedBy = "Supermercato")
    private Set<SupermercatoEntity> supermercatoEntities;

    @OneToMany(mappedBy = "Vestiti")
    private Set<VestitiSpeseQuotidianeEntity> vestitiEntities;
}