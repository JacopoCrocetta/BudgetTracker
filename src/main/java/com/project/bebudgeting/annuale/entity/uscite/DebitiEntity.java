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
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.AltriPrestitiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.AltroEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.CarteCreditoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.ImposteLocaliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.ImposteStataliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.PrestitiPerStudiareEntity;

@Entity
@Data
@Getter
@Setter
@Table(name = "Debiti")
@NoArgsConstructor
public class DebitiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany(mappedBy = "Altri_Prestiti")
    private Set<AltriPrestitiEntity> altriPrestitiEntities;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy = "Carte_Credito_O_Debito")
    private Set<CarteCreditoEntity> carteCreditoEntities;

    @OneToMany(mappedBy = "Imposte_Locali")
    private Set<ImposteLocaliEntity> imposteLocaliEntities;

    @OneToMany(mappedBy = "Imposte_Statali")
    private Set<ImposteStataliEntity> imposteStataliEntities;

    @OneToMany(mappedBy = "Prestiti_Studio")
    private Set<PrestitiPerStudiareEntity> prestitiPerStudiareEntities;
}