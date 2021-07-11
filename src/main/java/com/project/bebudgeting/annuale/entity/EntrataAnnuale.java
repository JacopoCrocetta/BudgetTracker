package com.project.bebudgeting.annuale.entity;

import com.project.bebudgeting.annuale.entity.entrate.AltreEntrateEntity;
import com.project.bebudgeting.annuale.entity.entrate.SalarioEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "EntrataAnnuale")
@Data
@NoArgsConstructor
@Getter
@Setter
public class EntrataAnnuale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy="Salario")
    private Set<SalarioEntity> salarioEntities;

    @OneToMany(mappedBy = "ALtreEntrate")
    private Set<AltreEntrateEntity> altreEntrateEntities;
}
