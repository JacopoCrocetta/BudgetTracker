package com.project.bebudgeting.annuale.entity.uscite;

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
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.AltroEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.BolloEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.CarburanteEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.FornitureEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.PrestitoAutoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.RiparazioniEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotrasporti.TrasportoPubblicoEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "Trasporti")
@NoArgsConstructor
public class TrasportiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany(mappedBy = "Bollo")
    private Set<BolloEntity> bolloEntities;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy = "Carburante")
    private Set<CarburanteEntity> carburanteEntities;

    @OneToMany(mappedBy = "Forniture")
    private Set<FornitureEntity> fornitureEntities;

    @OneToMany(mappedBy = "Prestito_Auto")
    private Set<PrestitoAutoEntity> prestitoAutoEntities;

    @OneToMany(mappedBy = "Riparazioni")
    private Set<RiparazioniEntity> riparazioniEntities;

    @OneToMany(mappedBy = "Trasporto_Pubblico")
    private Set<TrasportoPubblicoEntity> trasportoPubblicoEntities;
}