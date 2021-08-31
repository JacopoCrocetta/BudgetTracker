package com.project.bebudgeting.mensile.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.mensile.entity.effettivi.UsciteEffettiveEntity;
import com.project.bebudgeting.mensile.entity.previsti.UscitePrevisteEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "uscite_mensili")
@Data
@NoArgsConstructor
@Getter
@Setter
public class UsciteMensiliEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @OneToMany
    @JoinColumn(name = "iduscitemensile")
    private Set<UsciteEffettiveEntity> usciteEffettiveEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensile")
    private Set<UscitePrevisteEntity> uscitePrevisteEntities;
}
