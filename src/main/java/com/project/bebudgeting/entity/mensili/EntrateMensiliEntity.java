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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entrate_mensili")

/**
 * @return boolean
 */

/**
 * @return boolean
 */

/**
 * @return int
 */

/**
 * @return String
 */

/**
 * @return boolean
 */

/**
 * @return boolean
 */

/**
 * @return int
 */

/**
 * @return String
 */
@Data
@NoArgsConstructor

/**
 * @return int
 */

/**
 * @return LocalDate
 */

/**
 * @return List<EntrateEffettiveEntity>
 */

/**
 * @return List<EntratePrevisteEntity>
 */

/**
 * @return int
 */

/**
 * @return LocalDate
 */

/**
 * @return List<EntrateEffettiveEntity>
 */

/**
 * @return List<EntratePrevisteEntity>
 */
@Getter
@Setter
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
