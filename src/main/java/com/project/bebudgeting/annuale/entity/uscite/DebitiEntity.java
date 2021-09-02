package com.project.bebudgeting.annuale.entity.uscite;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.AltriPrestitiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.AltroDebitiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.CarteCreditoEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.ImposteLocaliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.ImposteStataliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliodebiti.PrestitiPerStudiareEntity;

@Entity
@Data
@Getter
@Setter
@Table(name = "debiti")
@NoArgsConstructor
public class DebitiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;
    String descrizione;

    @ManyToOne
    @JoinColumn(name = "iduscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany
    @JoinColumn(name = "iddebiti")
    private List<AltriPrestitiEntity> altriPrestitiEntities;

    @OneToMany
    @JoinColumn(name = "iddebiti")
    private List<AltroDebitiEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "iddebiti")
    private List<CarteCreditoEntity> carteCreditoEntities;

    @OneToMany
    @JoinColumn(name = "iddebiti")
    private List<ImposteLocaliEntity> imposteLocaliEntities;

    @OneToMany
    @JoinColumn(name = "iddebiti")
    private List<ImposteStataliEntity> imposteStataliEntities;

    @OneToMany
    @JoinColumn(name = "iddebiti")
    private List<PrestitiPerStudiareEntity> prestitiPerStudiareEntities;
}