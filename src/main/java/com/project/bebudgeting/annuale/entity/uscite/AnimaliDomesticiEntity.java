package com.project.bebudgeting.annuale.entity.uscite;

import com.project.bebudgeting.annuale.entity.UsciteAnnualiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AlimentiEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.AltroEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.FornitureEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.GiocattoliEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettaglianimalidomestici.VeterinarioEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Table(name = "Animali_Domestici")
@NoArgsConstructor
public class AnimaliDomesticiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany(mappedBy = "Alimenti")
    Set<AlimentiEntity> alimentiEntities;

    @OneToMany(mappedBy = "Altro")
    Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy = "Forniture")
    Set<FornitureEntity> fornitureEntities;

    @OneToMany(mappedBy = "Giocattoli")
    Set<GiocattoliEntity> giocattoliEntity;

    @OneToMany(mappedBy = "Veterinario")
    Set<VeterinarioEntity> veterinarioEntities;
}