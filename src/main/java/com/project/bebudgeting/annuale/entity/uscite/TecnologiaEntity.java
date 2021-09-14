package com.project.bebudgeting.annuale.entity.uscite;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.AltroTecnologiaEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.HardwareEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.HostingEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.ServiziOnlineEntity;
import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.SoftwareEntity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "tecnologia")
@NoArgsConstructor
public class TecnologiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;
    String descrizione;

    @OneToMany
    @JoinColumn(name = "idtecnologia")
    private List<HardwareEntity> hardwareEntities;

    @OneToMany
    @JoinColumn(name = "idtecnologia")
    private List<AltroTecnologiaEntity> altroEntities;

    @OneToMany
    @JoinColumn(name = "idtecnologia")
    private List<HostingEntity> hostingEntities;

    @OneToMany
    @JoinColumn(name = "idtecnologia")
    private List<ServiziOnlineEntity> serviziOnlineEntities;

    @OneToMany
    @JoinColumn(name = "idtecnologia")
    private List<SoftwareEntity> softwareEntities;
}