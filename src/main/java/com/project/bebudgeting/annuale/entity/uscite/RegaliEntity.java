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
import com.project.bebudgeting.annuale.entity.uscite.dettaglioregali.AltroEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioregali.DonazioniBeneficenzaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglioregali.RegaliDBEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "Regali")
@NoArgsConstructor
public class RegaliEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany(mappedBy = "Donazioni_Benefiche")
    private Set<DonazioniBeneficenzaEntity> donazioniBeneficenzaEntities;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy = "Libri_Comprati")
    private Set<RegaliDBEntity> regaliDBEntities;
}