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

import com.project.bebudgeting.entity.mensili.effettivi.EntrateEffettiveEntity;
import com.project.bebudgeting.entity.mensili.previsti.EntratePrevisteEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entrate_mensili")
@Data
@NoArgsConstructor
public class EntrateMensiliEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @OneToMany
    @JoinColumn(name = "identratemensile")
    private List<EntrateEffettiveEntity> entrateEffettiveEntities;

    @OneToMany
    @JoinColumn(name = "identratemensile")
    private List<EntratePrevisteEntity> entratePrevisteEntities;
}
