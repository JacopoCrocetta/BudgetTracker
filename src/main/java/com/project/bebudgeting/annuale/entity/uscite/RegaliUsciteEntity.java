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
import com.project.bebudgeting.annuale.entity.uscite.dettaglioregali.AltroRegaliEntity;
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
@Table(name = "regali_uscite")
@NoArgsConstructor
public class RegaliUsciteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "idregaliuscite")
    private Set<DonazioniBeneficenzaEntity> donazioniBeneficenzaEntities;

    @OneToMany
    @JoinColumn(name = "idregaliuscite")
    private Set<AltroRegaliEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idregaliuscite")
    private Set<RegaliDBEntity> regaliDBEntities;
}