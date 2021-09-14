package com.project.bebudgeting.annuale.entity.uscite;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.AffittoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.AltroCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ArredamentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.FornitureCasaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.GiardinaggioEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ImposteImmobiliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ManutenzioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.MiglioramentiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.TraslocoEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany
    @JoinColumn(name = "idcasa")
    private List<AffittoEntity> affittoEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private List<AltroCasaEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private List<ArredamentoEntity> arredamentoEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private List<FornitureCasaEntity> fornitureEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private List<GiardinaggioEntity> giardinaggioEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private List<ImposteImmobiliEntity> imposteImmobiliEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private List<ManutenzioneEntity> manutenzioneEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private List<MiglioramentiEntity> miglioramentiEntities;

    @OneToMany
    @JoinColumn(name = "idcasa")
    private List<TraslocoEntity> traslocoEntities;
}