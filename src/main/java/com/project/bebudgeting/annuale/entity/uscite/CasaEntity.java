package com.project.bebudgeting.annuale.entity.uscite;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.AltroEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ArredamentoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.FornitureEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.GiardinaggioEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ImposteImmobiliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.ManutenzioneEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.MiglioramentiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliocasa.TraslocoEntity;

@Entity
@Data
@Getter
@Setter
@Table(name = "Casa")
@NoArgsConstructor
public class CasaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany(mappedBy = "Affitto")
    private Set<AffittoEntity> affittoEntities;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy = "Arredamento")
    private Set<ArredamentoEntity> arredamentoEntities;

    @OneToMany(mappedBy = "Forniture")
    private Set<FornitureEntity> fornitureEntities;

    @OneToMany(mappedBy = "Giardinaggio")
    private Set<GiardinaggioEntity> giardinaggioEntities;

    @OneToMany(mappedBy = "Imposte_Immobiliari")
    private Set<ImposteImmobiliEntity> imposteImmobiliEntities;

    @OneToMany(mappedBy = "Manutenzione")
    private Set<ManutenzioneEntity> manutenzioneEntities;

    @OneToMany(mappedBy = "Miglioramenti")
    private Set<MiglioramentiEntity> miglioramentiEntities;

    @OneToMany(mappedBy = "Trasloco")
    private Set<TraslocoEntity> traslocoEntities;
}