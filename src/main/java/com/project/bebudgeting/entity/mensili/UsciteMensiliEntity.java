package com.project.bebudgeting.entity.mensili;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.entity.mensili.effettivi.UsciteEffettiveEntity;
import com.project.bebudgeting.entity.mensili.previsti.UscitePrevisteEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "uscite_mensili")
@Data
@NoArgsConstructor
public class UsciteMensiliEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @OneToMany
    @JoinColumn(name = "iduscitemensile")
    private List<UsciteEffettiveEntity> usciteEffettiveEntities;

    @OneToMany
    @JoinColumn(name = "iduscitemensile")
    private List<UscitePrevisteEntity> uscitePrevisteEntities;
}
