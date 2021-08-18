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
import com.project.bebudgeting.annuale.entity.uscite.dettagliotecnologia.AltroEntity;
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
@Table(name = "Tecnologia")
@NoArgsConstructor
public class TecnologiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    LocalDate data_inserimento;

    @ManyToOne
    @JoinColumn(name = "idUscita")
    private UsciteAnnualiEntity uscitaAnnuale;

    @OneToMany(mappedBy = "Hardware")
    private Set<HardwareEntity> hardwareEntities;

    @OneToMany(mappedBy = "Altro")
    private Set<AltroEntity> altroEntities;

    @OneToMany(mappedBy = "Hosting")
    private Set<HostingEntity> hostingEntities;

    @OneToMany(mappedBy = "Servizi_Online")
    private Set<ServiziOnlineEntity> serviziOnlineEntities;

    @OneToMany(mappedBy = "Software")
    private Set<SoftwareEntity> softwareEntities;
}