package com.project.bebudgeting.annuale.entity.uscite;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.AffittoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.AltroCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ArredamentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.FornitureCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.GiardinaggioEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ImposteImmobiliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ManutenzioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.MiglioramentiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.TraslocoEntity;

@Entity
@Data
@Getter
@Setter
@Table(name = "casa")
@NoArgsConstructor
public class CasaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;
    String descrizione;

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private Set<AffittoEntity> affittoEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private Set<AltroCasaEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private Set<ArredamentoEntity> arredamentoEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private Set<FornitureCasaEntity> fornitureEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private Set<GiardinaggioEntity> giardinaggioEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private Set<ImposteImmobiliEntity> imposteImmobiliEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private Set<ManutenzioneEntity> manutenzioneEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private Set<MiglioramentiEntity> miglioramentiEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private Set<TraslocoEntity> traslocoEntities;
}